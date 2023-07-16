package ug.co.absa.notify.service;

import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.domain.models.AccountRequest;
import ug.co.absa.notify.domain.models.ValidationResponse;
import ug.co.absa.notify.repository.AlertsTbRepository;
import ug.co.absa.notify.repository.ChannelTxnRepository;
import ug.co.absa.notify.utility.ApiInterface;
import ug.co.absa.notify.utility.ServiceGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
@Async
@Transactional
public class ScheduledTasks {

    private final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final ChannelTxnRepository channelTxnRepository;
    private final AlertsTbRepository alertsTbRepository;



    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public ScheduledTasks(ChannelTxnRepository channelTxnRepository, AlertsTbRepository alertsTbRepository) {
        this.channelTxnRepository = channelTxnRepository;
        this.alertsTbRepository = alertsTbRepository;
    }




    @Scheduled(fixedDelay = 60, initialDelay = 0, timeUnit = TimeUnit.SECONDS)
    public void showHowAndCleanUp()
    {
        log.debug(":::::::::::SCHEDULE HAS BEEN CALLED::::::::::::;::::::\n");
        log.debug(":::::::::::THE FOLLOWING ACTIVITIES WILL HAPPEN:::::::\n");
        log.debug("*Fetch all Umeme transactions from the channels DB****\n");
        log.debug("*Create an Alert and insert into the alerts Table*****\n");
        log.debug("*Fetch all Umeme transactions from the channels DB****\n");
        log.debug("*Fetch fetch Emails for all transactions**************\n");
        log.debug("*create Alerts and Insert  into alerts ***************\n");
        log.debug("*Fetch all alerts and send out one by one ************\n");
        log.debug("::::::::::::::::::::::::::::LETS GET STARTED::::::::::\n");

    }


    @Scheduled(fixedDelay = 10, initialDelay = 2, timeUnit = TimeUnit.SECONDS)
    public void saveTransactionAlerts() throws InterruptedException {
        //fetch all umeme transactions from the channels DB
        log.debug("fetch all  transactions from the channels DB\n");

        List<ChannelTxn> channelTxns = channelTxnRepository.findAll();
        // saveAllTransaction( channelTxnRepository.GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME());

        if (channelTxns.size() > 0) {
            log.debug("list size :  {}",channelTxns.size());
            saveAllTransaction(channelTxns);

            Thread.sleep(1000);
            UpdateEmailsOnAlerts();
        }
        else{
            log.debug("No Umeme Transactions found to be used to create alerts");
        }

    }

    @Async
    private void UpdateEmailsOnAlerts() {
        log.debug(":::::::::::::::::::::runScheduleToUpdateEmails:::::::::::::::::::::::::::");
        Optional<List<AlertsTb>> alertsList = alertsTbRepository.findAllPendingAlertsTb("PENDING");
        alertsList.get();
        if (alertsList.get().size() > 0) {
            for (AlertsTb alertsTb : alertsList.get()) {
                log.debug("AlertsTb: {} ", alertsTb.toString());
                queryEmailAddress(alertsTb);
            }
        } else { log.debug("No Alerts to be created");}


    }
    private void queryEmailAddress(@NotNull AlertsTb alertsTb) {
        log.debug("Update all transactions with email address");
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        log.debug("First pick all alerts");
        AccountRequest accountRequest= new AccountRequest(alertsTb.getAlertFreeField2(),alertsTb.getAlertId());
        log.debug("****GET EMAIL FOR: "+ accountRequest.accountNumber());

        Call<ValidationResponse> call = apiInterface.getCustomerEmail(accountRequest );
        call.enqueue(new Callback<ValidationResponse>() {
            @Override
            public void onResponse(@NotNull Call<ValidationResponse> call, @NotNull Response<ValidationResponse> response) {
                if (response.isSuccessful()) {
                    log.debug
                        ("After picking mail Response: {}", response.body());
                    if ((response.body()!=null))
                    {
                        if((response.body().returnCode.equalsIgnoreCase("200")))
                        {
                            log.debug("mail fetching successfull: "+ response.body());
                            if((response.body().accountName!=null))
                            {
                                alertsTb.setAlertFreeField1(response.body().accountName);
                                channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS("3",alertsTb.getAlertId());

                            }else{
                                alertsTb.setStatus("No Account Mail");
                                channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS("No Email Found",alertsTb.getAlertId());

                            }

                        }
                    }

                } else {
                    log.debug("Response: {}", response.errorBody());
                }
            }


            @Override
            public void onFailure(@NotNull Call<ValidationResponse> call, @NotNull Throwable t) {
                log.error("Error: {}", t.getMessage());
            }
        });


    }


    private void saveAllTransaction( List<ChannelTxn> channelTxns) {

            log.debug("ALL AVAILABLE UMEME TRANSACTIONS IN THE PAST 1 MINUTE  NUMBER OF ITEMS PICKED: {} ", channelTxns.size());
            for (ChannelTxn channelTxn : channelTxns) {
                log.debug("insertionof Alerts one by one email: {} ",channelTxn.toString());
                log.debug(channelTxn.toString());
                    log.debug(":::::::::::::::::INSERT TRANSACTION: {}",channelTxn.toString());
                    AlertsTb alertsTb= ChannelTxn.ToAlertsTb(channelTxn);
                     saveAlerts(alertsTb) ;
            log.debug(":::::::::::::::::INSERT TRANSACTION ENDS HERE");
            }

    }

    private void saveAlerts(AlertsTb  alerts)
    {
        if (alerts!=null)
        {
            log.debug("Account Number before insert : {} ",alerts.getAlertFreeField2());
            alertsTbRepository.saveAndFlush(alerts);

        }else{
            log.debug("No Alerts to be created");
        }
    }






}
