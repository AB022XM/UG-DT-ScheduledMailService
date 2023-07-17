/*
package ug.co.absa.notify.service;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import okhttp3.OkHttpClient;
import org.hibernate.annotations.CurrentTimestamp;
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
import tech.jhipster.config.JHipsterProperties;
import ug.co.absa.notify.domain.AlertsHistoryTb;
import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.ChannelTxn;
import ug.co.absa.notify.domain.models.AccountRequest;
import ug.co.absa.notify.domain.models.EmailContent;
import ug.co.absa.notify.domain.models.MailApiRequest;
import ug.co.absa.notify.domain.models.ValidationResponse;
import ug.co.absa.notify.repository.AlertsTbRepository;
import ug.co.absa.notify.repository.ChannelTxnRepository;
import ug.co.absa.notify.utility.ApiInterface;
import ug.co.absa.notify.utility.Helpers;
import ug.co.absa.notify.utility.ServiceGenerator;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Service
@Async
@Transactional
public class QuickReactTasks {

    private final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private final ChannelTxnRepository channelTxnRepository;
    private final AlertsTbRepository alertsTbRepository;



    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    public QuickReactTasks(ChannelTxnRepository channelTxnRepository, AlertsTbRepository alertsTbRepository) {
        this.channelTxnRepository = channelTxnRepository;
        this.alertsTbRepository = alertsTbRepository;
    }




    @Scheduled(fixedDelay = 60, initialDelay = 0, timeUnit = TimeUnit.SECONDS)
    public void showHowAndCleanUp()
    {
        log.debug("QK:::::::::::SCHEDULE HAS BEEN CALLED::::::::::::;::::::\n");
        log.debug(":::::::::::THE FOLLOWING ACTIVITIES WILL HAPPEN:::::::\n");
        log.debug("QK*Fetch all Umeme transactions from the channels DB****\n");
        log.debug("QK*Create an Alert and insert into the alerts Table*****\n");
        log.debug("QK*Fetch all Umeme transactions from the channels DB****\n");
        log.debug("QK*Fetch fetch Emails for all transactions**************\n");
        log.debug("QK*create Alerts and Insert  into alerts ***************\n");
        log.debug("*QKFetch all alerts and send out one by one ************\n");
        log.debug("::::::::::::::::::::::::::::LETS GET STARTED::::::::::\n");

    }




    @Async
    @Scheduled(fixedDelay = 15, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void sendEmailScheduled() {
        List<ChannelTxn> channelTxns = channelTxnRepository.GET_ALL_CHANNELS_TRANS_IN_THE_PAST_2_MINUTES_UMEME();

        if (channelTxns.size() > 0) {
            log.debug("list size :  {}", channelTxns.size());
            for (ChannelTxn channelTxn : channelTxns) {
                queryEmailAndSendAlert(channelTxn);
            }
        } else {
            log.debug("No Umeme Transactions found to be used to create alerts");
        }
    }



   Response  sendQuickAlert()
   {
        OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\r\n  \"EmailContent\": {\r\n    \"EmailSubject\": \"TEST:ABSA Bank Uganda – UMEME PREPAID TOKEN (YAKA)\",\r\n    \"EmailFrom\": \"noreply@absa.za\",\r\n    \"EmailBody\": \"<p>!!  etal oot ylbaborp sti ,siht gniviecer ruoy fi,  01100010 00100000 00110001 00110011<\\b></p><p>You can call us on 0800 222 333 / +256 312 218 348 or WhatsApp +256 707 433 433 in case you require more details.</p><p>Thank you for choosing Absa Bank.</p><p>Your sincerely, Absa Bank Digital</p>\",\r\n    \"isSchedules\": false\r\n  },\r\n  \"EmailAddreses\": [ \"rosenlindsey7@gmail.com\"],\r\n  \"CopyInEmails\": [\"i24smael@gmail.com\"],\r\n\r\n  \"Attachments\": []\r\n\r\n}");
        Request request = new Request.Builder()
            .url("https://ugpbhkmapp0002.corp.dsarena.com:19020/api/v1/SendMail")
            .method("POST", body)
            .addHeader("Content-Type", "application/json")
            .build();
       return  client.newBuilder().build().newCall(request).execute();
    }

    private void  queryEmaailAndSendAlert(@NotNull ChannelTxn channelTxn) {
    */
/*    log.debug("Update all transactions with email address");
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        log.debug("First pick all alerts");
        final String[] email = {null};
        AccountRequest accountRequest= new AccountRequest(channelTxn.getAccountNo(),channelTxn.getTxnID());
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
                                email[0] = response.body().accountName;
                                log.debug("email: "+ email[0]);

                                sendoutMail( channelTxn,  email[0]);
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
        });*//*


    }




    private void sendoutMail(ChannelTxn channelTxn,String email)
    {
        log.debug(":::::::::::::::::::::sendoutMail:::::::::::::::::::::::\n");
        log.debug(":::::::::::::::::::::SENDING EMAIL:::::::::::::::::::::::\n");
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);
        EmailContent emailContent =new EmailContent("ABSA UMEME PREPAID EMAIL TOKEN NOTIFICATION",
            "noreply@absa.africa",Helpers.createEmailBody(channelTxn),true);
        List<String> emailAddresses = new ArrayList<>();
        emailAddresses.add(email);
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


            }


            @Override
            public void onFailure(Call<MailApiRequest> call, Throwable throwable) {
                log.debug(":::::::::::::::::::::SENT MAIL FAILED:::::::::::::::::::::::\n");

            }
        });

    }






}
*/
