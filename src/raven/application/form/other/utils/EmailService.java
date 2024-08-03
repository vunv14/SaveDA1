/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package raven.application.form.other.utils ;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Nguyen Nam Truong
 */
public class EmailService {
     public  void sendEmail(String to, String password) throws Exception {
        String from = "vietbingu408@gmail.com";
        String host = "smtp.gmail.com";
        String port = "587";
        String username = "vietbingu408@gmail.com";
        String emailPassword = "flkxaklbfjutzmsz";
        
        // Create properties for the email session
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        
        // Create a new session with an authenticator
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, emailPassword);
            }
        };
        Session session = Session.getInstance(properties, authenticator);
        
        // Create a new email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Your new password");
        message.setText("Your new password is: " + password);
        
        // Send the email message
        Transport.send(message);
    }
}
