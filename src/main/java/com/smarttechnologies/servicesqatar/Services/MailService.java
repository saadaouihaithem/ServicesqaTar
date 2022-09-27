package com.smarttechnologies.servicesqatar.Services;


import com.smarttechnologies.servicesqatar.Entities.NotificationEmail;
import com.smarttechnologies.servicesqatar.Exception.SpringRedditException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

    @Service
    @AllArgsConstructor
    @Slf4j
    public class MailService {

        private final JavaMailSender mailSender;

        @Async
        void sendMail(NotificationEmail notificationEmail) {
            MimeMessagePreparator messagePreparator = mimeMessage -> {
                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setFrom("saadaouihaithemt@email.com");
                messageHelper.setTo(notificationEmail.getRecipient());
                messageHelper.setSubject(notificationEmail.getSubject());
                messageHelper.setText(notificationEmail.getBody());
            };
            try {
                mailSender.send(messagePreparator);
                log.info("Activation email sent!!");
            } catch (MailException e) {
                log.error("Exception occurred when sending mail");
                throw new SpringRedditException("Exception occurred when sending mail to " + notificationEmail.getRecipient());
            }
        }
}
