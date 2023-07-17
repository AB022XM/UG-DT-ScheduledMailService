package ug.co.absa.notify.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.jhipster.config.JHipsterProperties;
import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.AlertsTemplateTb;
import ug.co.absa.notify.domain.User;
import ug.co.absa.notify.domain.models.*;
import ug.co.absa.notify.repository.AlertsHistoryTbRepository;
import ug.co.absa.notify.repository.AlertsTbRepository;
import ug.co.absa.notify.repository.AlertsTemplateTbRepository;
import ug.co.absa.notify.repository.ChannelTxnRepository;
import ug.co.absa.notify.utility.ApiInterface;
import ug.co.absa.notify.utility.Errors;
import ug.co.absa.notify.utility.Helpers;
import ug.co.absa.notify.utility.ServiceGenerator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Service
@Async
@Transactional
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private final JHipsterProperties jHipsterProperties;


    public final AlertsTbRepository alertsTbRepository;

    private final JavaMailSender javaMailSender;

    private final ChannelTxnRepository channelTxnRepository;
    public final AlertsTemplateTbRepository alertsTemplateTbRepository;

    public final AlertsHistoryTbRepository alertsHistoryTbRepository;

    public MailService(
        JHipsterProperties jHipsterProperties,
        JavaMailSender javaMailSender,
        AlertsTbRepository alertsTbRepository,
        ChannelTxnRepository channelTxnRepository,
        AlertsHistoryTbRepository alertsHistoryTbRepository,
        AlertsTemplateTbRepository alertsTemplateTbRepository) {
        this.jHipsterProperties = jHipsterProperties;
        this.javaMailSender = javaMailSender;
        this.alertsTbRepository = alertsTbRepository;
        this.channelTxnRepository = channelTxnRepository;
        this. alertsHistoryTbRepository = alertsHistoryTbRepository;
        this.alertsTemplateTbRepository = alertsTemplateTbRepository;


    }


    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug(
            "Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
            isMultipart,
            isHtml,
            to,
            subject,
            content
        );

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom(jHipsterProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (MailException | MessagingException e) {
            log.warn("Email could not be sent to user '{}'", to, e);
        }
    }

    @Async
    public void sendEmailFromTemplate(User user, String templateName, String titleKey) {
     /*   if (user.getEmail() == null) {
            log.debug("Email doesn't exist for user '{}'", user.getLogin());
            return;
        }
        Locale locale = Locale.forLanguageTag(user.getLangKey());
        Context context = new Context(locale);
        context.setVariable(USER, user);
        context.setVariable(BASE_URL, jHipsterProperties.getMail().getBaseUrl());
        String content = templateEngine.process(templateName, context);
        String subject = messageSource.getMessage(titleKey, null, locale);
        sendEmail(user.getEmail(), subject, content, false, true);*/
    }

    @Async
    public void sendActivationEmail(User user) {
        log.debug("Sending activation email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
    }

    @Async
    public void sendCreationEmail(User user) {
        log.debug("Sending creation email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/creationEmail", "email.activation.title");
    }

    @Async
    public void sendPasswordResetMail(User user) {
        log.debug("Sending password reset email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/passwordResetEmail", "email.reset.title");
    }




    @Async
   @Scheduled(fixedDelay = 20, initialDelay = 10, timeUnit = TimeUnit.SECONDS)
    protected void sendEmailScheduled() {
      AlertsTemplateTb alertsTemplateTb= alertsTemplateTbRepository.findOneByAlertTemplateId("1");



        List<AlertsTb>  alertsTbList= alertsTbRepository.findAll();
        if(!alertsTbList.isEmpty())
        {

            alertsTbList.forEach(alertsTb ->{
                    log.debug(":::::::::::::::::::::SENDING EMAIL if email is not null:::::::::::::::::::::::\n");
                    log.debug("CONTENT :  "+alertsTb.toString());
                    if(alertsTb.getAlertFreeField1()!=null)
                    {
                        if (alertsTemplateTb != null) {
                            sendoutMail(alertsTb);
                        }{
                            log.debug(":::::::::::ALERTS NOT SENT, ADD A RECORD IN ALERT TEMPLETE:::::::::::::::::::::::\n");

                        }
                    }




                }

            );
        }else {
            log.debug("No alerts found to send");
        }
    }

    protected void sendoutMail(AlertsTb alertsTb)
    {
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
        log.debug("CONTENT SENT OUT TO CUSTOMER: {} ",mailApiRequest.toString());
        Call<EmailApiResponse> call = apiInterface.sendMail(mailApiRequest);
        call.enqueue(new Callback<EmailApiResponse>() {
            @Override
            public void onResponse(Call<EmailApiResponse> call, Response<EmailApiResponse> response) {
                log.debug(":::::::::::::::::::::SENT MAIL:::::::::::::::::::::::\n");
                log.debug("****DETAILS: "+ response.body());
                      if(response.body()!=null)
                      {

                    if (response.body().getErrorCode()!=null &&
                        response.body().getErrorCode().equalsIgnoreCase("200"))
                    {
                        log.debug(":::::::::::::::::::::sendoutMail:::::::::::::::::::::::\n");

                        channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS("3",alertsTb.getAlertId());
                       alertsTbRepository.updateAlertStatusByAlertId(String.valueOf(Errors.SUCCESS.getId()), Errors.SUCCESS.getMessage(),alertsTb.getAlertId());
                    }else
                    {
                        alertsTbRepository.updateAlertStatusByAlertId(String.valueOf(Errors.FAILURE.getId()), Errors.FAILED_TO_SEND_MAIL.getMessage(), alertsTb.getAlertId());

                    }


                      }


            }

            @Override
            public void onFailure(Call<EmailApiResponse> call, Throwable throwable) {
                log.debug(":::::::::::::::::::::SENT MAIL FAILED:::::::::::::::::::::::\n");
                alertsTbRepository.updateAlertStatusByAlertId(String.valueOf(Errors.UNKNOWN_EXCEPTION_.getId()), Errors.FAILED_TO_SEND_MAIL.getMessage(), alertsTb.getAlertId());

            }
        });

    }


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
                ValidationResponse validateResponse = response.body();
                if (response.isSuccessful()) {
                    log.debug
                        ("After picking mail Response: {}", response.body());
                    if (validateResponse==null ) {
                        log.debug("No response from  GETEMAIL ");

                        return;
                    }
                        if(validateResponse.emailAddress!=null)
                        {
                            log.debug("Email found"+ validateResponse.getEmailAddress() );
                            channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS(String.valueOf(Errors.SUCCESS.getId()),alertsTb.getAlertId());
                            alertsTb.setAlertFreeField1(alertsTb.getAlertFreeField1());
                            log.debug("AlertsTb     AFTER MAIL UPDATE: {} ", alertsTb.toString());

                        }else {

                           alertsTb.setStatus(String.valueOf(Errors.WARNING_NO_MAIL_FOUND.getId()));
                            alertsTb.setAlertFreeField5(Errors.WARNING_NO_MAIL_FOUND.getMessage());
                        }

                    if((validateResponse.accountName!=null))
                    {
                        alertsTbRepository.updateAlertFreeField5ByAlertId(alertsTb.getAlertFreeField3(),
                            alertsTb.getAlertId());// update name field 5
                    }

                  //  channelTxnRepository.UPDATE_CHANNEL_TXN_STATUS("",alertsTb.getAlertId());


                } else {
                    log.debug("Response: {}", response.errorBody());
                }
            }


            @Override
            public void onFailure(@NotNull Call<ValidationResponse> call, @NotNull Throwable t) {
                log.error("Error: {}", t.getMessage());
                alertsTbRepository.updateAlertStatusByAlertId(Errors.FAILED_TO_SEND_MAIL.getMessage(),
                    "",alertsTb.getAlertId());
            }
        });


    }



}


