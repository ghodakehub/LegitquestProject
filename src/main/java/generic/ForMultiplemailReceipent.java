package generic;
import javax.mail.*;
import javax.mail.internet.*;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class ForMultiplemailReceipent {
	public static void sendEmail(WebDriver driver,String[] recipients, String subject, String body, String filePath,String testUrl) throws MessagingException {
        // Set properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.socketFactory.port", "465");
    	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // Enable SSL
    	props.put("mail.smtp.socketFactory.fallback", "false");

        // Create a session
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("pratiksha.damodar@legitquest.com", "qxfr qcts ycwu eokj");
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pratiksha.damodar@legitquest.com"));

            // Set recipients
            Address[] recipientAddresses = new Address[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                recipientAddresses[i] = new InternetAddress(recipients[i]);
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddresses);

            // Set subject
            message.setSubject(subject);
            // Create the email body part
          

            // Set email body
           // MimeBodyPart textPart = new MimeBodyPart();
          //  textPart.setText(body);

            MimeBodyPart textPart = new MimeBodyPart();
            String emailBody = body;

            // If testUrl is provided, append it to the body
            if (testUrl != null && !testUrl.isEmpty()) {
                emailBody += "\nTest URL: " + testUrl;
            }
            textPart.setText(emailBody);

            
            
            

            // Attach file if provided
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textPart);

            if (filePath != null && !filePath.isEmpty()) {
                MimeBodyPart attachmentPart = new MimeBodyPart();
                attachmentPart.attachFile(filePath);
                multipart.addBodyPart(attachmentPart);
            }

            // Set the content
            message.setContent(multipart);

            // Send email
            Transport.send(message);
            System.out.println("Email sent successfully to: " + String.join(", ", recipients));

        } catch (Exception e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send email", e);
        }
    }
}


