package com.hF.hFcave.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sound.midi.MidiMessage;
import java.time.LocalTime;
import java.util.Properties;

@Service
public class MailSender {

    final String from ="ofbrick121@gmail.com";
    String host = "smtp.google.com";
    String smtpPort ="465";

    Properties properties = new Properties();
    {
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port",smtpPort);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth","true");
    }

    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, "nnmtuzrzseynnkxi");
        }
    });

    public void send(String recipientGmail, String text, String subject, int hour, int minute) throws MessagingException {
        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientGmail));
        message.setSubject("hFcave Industry: " + subject);
        message.setText(text);

        if(LocalTime.now().getHour() == hour && LocalTime.now().getMinute() == minute && LocalTime.now().getSecond() == 1) {
            Transport.send(message);
        }
    }

}
