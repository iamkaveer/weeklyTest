package com.example.Weekly_Test;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Properties;

@Service
public class MailService {

    private final String HOST = "smtp.gmail.com";
    private final String SENDER = "kabirhossain293@gmail.com";
    private final String PASSWORD = " ";
    private final String RECEIVER = "iamkaveer1384@gmail.com"
    private final Properties properties = new Properties();
    @Autowired
    public MailService() {
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
    }
    public void sendEmail(String subject, String body) throws MessagingException {
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SENDER, PASSWORD);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(SENDER));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(RECEIVER));
        message.setSubject(subject);
        message.setText(body);
        Transport.send(message);
    }
}
