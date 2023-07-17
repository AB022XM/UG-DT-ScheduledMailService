package ug.co.absa.notify.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.repository.AlertsHistoryTbRepository;
import ug.co.absa.notify.repository.AlertsTbRepository;
import ug.co.absa.notify.repository.ChannelTxnRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Async
@Transactional
public class ScheduledTasks {

    private final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final ChannelTxnRepository channelTxnRepository;
    private final AlertsTbRepository alertsTbRepository;

   private final AlertsHistoryTbRepository alertsHistoryTbRepository;



    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public ScheduledTasks(ChannelTxnRepository channelTxnRepository, AlertsTbRepository alertsTbRepository,
                          AlertsHistoryTbRepository  alertsHistoryTbRepository) {
        this.channelTxnRepository = channelTxnRepository;
        this.alertsTbRepository = alertsTbRepository;
        this.alertsHistoryTbRepository=alertsHistoryTbRepository;
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



    @Scheduled(fixedDelay = 60, initialDelay = 3, timeUnit = TimeUnit.SECONDS)
    protected void saveTransactionAlerts() throws InterruptedException {
        //fetch all umeme transactions from the channels DB
        log.debug("fetch all  transactions from the channels DB\n");

        List<ChannelTxn> channelTxns = channelTxnRepository.GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME();
        // saveAllTransaction( channelTxnRepository.GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME());

        if (channelTxns.size() > 0) {
            log.debug("list size :  {}",channelTxns.size());
            new Thread(() -> {
                saveAllTransaction(channelTxns);
            }).start();
            Thread.sleep(1000);
        }
        else{
            log.debug("No Umeme Transactions found to be used to create alerts");
        }

    }
/*


    @Scheduled(fixedDelay = 15, initialDelay = 3, timeUnit = TimeUnit.SECONDS)
    protected void UpdateEmailsOnAlerts() throws InterruptedException {
        log.debug(":::::::::::::::::::::runScheduleToUpdateEmails:::::::::::::::::::::::::::");
        List<AlertsTb> alertsList = alertsTbRepository.findAll();
        if (alertsList.size() > 0) {
            for (AlertsTb alertsTb : alertsList) {
                log.debug("AlertsTb: {} ", alertsTb.toString());
                if(!alertsTb.getAlertFreeField1().contains("@") || alertsTb.getAlertFreeField1().isEmpty())
                {
                    new Thread(() -> {
                        queryEmailAddress(alertsTb);
                    }).start();
                    Thread.sleep(1000);
                }
            }
        } else { log.debug("No Alerts to be created");}


    }
*/


    private void saveAllTransaction( List<ChannelTxn> channelTxns) {

            log.debug("ALL AVAILABLE UMEME TRANSACTIONS IN THE PAST 1 MINUTE  NUMBER OF ITEMS PICKED: {} ", channelTxns.size());
            for (ChannelTxn channelTxn : channelTxns) {
                log.debug("insertionof Alerts one by one email: {} ",channelTxn.toString());
                log.debug(channelTxn.toString());
                    log.debug(":::::::::::::::::INSERT TRANSACTION: {}",channelTxn.toString());
                    AlertsTb alertsTb= ChannelTxn.ToAlertsTb(channelTxn);
                     saveAlerts(alertsTb) ;
               log.debug(":::::::::::::::::INSERT TRANSACTION ENDS HERE:::ALERT");
                log.debug(alertsTb.toString());

            }

    }



    private void saveAlerts(AlertsTb  alerts)
    {
        if (alerts!=null)
        {
            log.debug("Account Number before insert : {} ",alerts.getAlertFreeField2());
            alertsTbRepository.save(alerts);

        }else{
            log.debug("No Alerts to be created");
        }
    }

/*     void sendOutMultipleMails()
     {
         List<ChannelTxn>
         channelTxns = channelTxnRepository.GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME();
         if (channelTxns.size() > 0) {
             for (ChannelTxn channelTxn : channelTxns) {
                 AlertsTb alertsTb= ChannelTxn.ToAlertsTb(channelTxn);
                 sendoutMail( alertsTb)   ;          }

         } else {
             log.debug("No Umeme Transactions found to be used to create alerts");
         }


     }*/
/*
    public void sendoutMail(AlertsTb alertsTb)
    {

        log.debug(":::::::::::::::::::::sendoutMail:::::::::::::::::::::::\n");
        log.debug(":::::::::::::::::::::SENDING EMAIL:::::::::::::::::::::::\n");
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        EmailContent emailContent = Helpers.generateEmailContent(alertsTb);
        List<String> emailAddresses = new ArrayList<>();
        emailAddresses.add(alertsTb.getAlertFreeField1());
        MailApiRequest mailApiRequest= new MailApiRequest();
        mailApiRequest.setEmailAddreses(emailAddresses);
        mailApiRequest.setAttachments(new ArrayList<>());
        mailApiRequest.setCopyInEmails(new ArrayList<>());
        mailApiRequest.setEmailContent(emailContent);
        log.debug(mailApiRequest.toString());
        Call<MailApiRequest> call = apiInterface.sendMail(mailApiRequest);
        call.enqueue(new Callback<MailApiRequest>() {
            @Override
            public void onResponse(Call<MailApiRequest> call, Response<MailApiRequest> response) {
                log.debug(":::::::::::::::::::::SENT MAIL:::::::::::::::::::::::\n");
                log.debug("****DETAILS: "+ response.body());
                try {

                    Thread.sleep(500);


                    AlertsHistoryTb.InsertAlertsHistoryTbFromAlertsTbObj( alertsTb, alertsHistoryTbRepository) ;
                    channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS("3",alertsTb.getAlertId());


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }



            }


            @Override
            public void onFailure(Call<MailApiRequest> call, Throwable throwable) {
                log.debug(":::::::::::::::::::::SENT MAIL FAILED:::::::::::::::::::::::\n");

            }
        });

    }
*/






}
