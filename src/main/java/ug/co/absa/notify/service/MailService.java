package ug.co.absa.notify.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.spring6.SpringTemplateEngine;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tech.jhipster.config.JHipsterProperties;
import ug.co.absa.notify.domain.AlertsHistoryTb;
import ug.co.absa.notify.domain.AlertsTb;
import ug.co.absa.notify.domain.User;
import ug.co.absa.notify.domain.models.*;
import ug.co.absa.notify.repository.AlertsHistoryTbRepository;
import ug.co.absa.notify.repository.AlertsTbRepository;
import ug.co.absa.notify.repository.AlertsTemplateTbRepository;
import ug.co.absa.notify.repository.ChannelTxnRepository;
import ug.co.absa.notify.utility.ApiInterface;
import ug.co.absa.notify.utility.Helpers;
import ug.co.absa.notify.utility.ServiceGenerator;

import java.nio.charset.StandardCharsets;
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






    //@Async
   // @Scheduled(fixedDelay = 10, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void sendEmailScheduled() {
        List<AlertsTb>  alertsTbList= alertsTbRepository.findAll();
        if(!alertsTbList.isEmpty())
        {

            alertsTbList.forEach(alertsTb ->{
                    log.debug(":::::::::::::::::::::SENDING EMAIL:::::::::::::::::::::::\n");
                    log.debug("CONTENT :  "+alertsTb.toString());
                    sendoutMail(alertsTb);
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            );
        }else {
            log.debug("No alerts found to send");
        }
    }

    public void sendoutMail(AlertsTb alertsTb)
    {
        EmailContent emailContent = Helpers.generateEmailContent(alertsTb);
        ApiInterface apiInterface = ServiceGenerator.createService(ApiInterface.class);

        Call<EmailApiResponse> call = apiInterface.sendMail(emailContent);
        call.enqueue(new Callback<EmailApiResponse>() {
            @Override
            public void onResponse(Call<EmailApiResponse> call, Response<EmailApiResponse> response) {
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
            public void onFailure(Call<EmailApiResponse> call, Throwable throwable) {
                log.debug(":::::::::::::::::::::SENT MAIL FAILED:::::::::::::::::::::::\n");

            }
        });

    }




}


