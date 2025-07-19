package generic;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.util.ByteArrayDataSource;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class EmailUtility {
	public static void sendEmailWithAttachment(String subject, String messageBody, String[] recipients, List<byte[]> screenshotBytesList) throws MessagingException {
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "465");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	    Session session = Session.getInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication("pratiksha.damodar@legitquest.com", "qxfr qcts ycwu eokj");
	        }
	    });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("pratiksha.damodar@legitquest.com"));
	        for (String recipient : recipients) {
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
	        }
	        message.setSubject(subject);

	        // Create HTML Part
	        MimeBodyPart messageBodyPart = new MimeBodyPart();
	        StringBuilder emailContent = new StringBuilder(messageBody);

	        Multipart multipart = new MimeMultipart();

	        multipart.addBodyPart(messageBodyPart);

	        if (screenshotBytesList != null && !screenshotBytesList.isEmpty()) {
	            int index = 0;
	            for (byte[] screenshot : screenshotBytesList) {
	                MimeBodyPart imagePart = new MimeBodyPart();
	                ByteArrayDataSource dataSource = new ByteArrayDataSource(screenshot, "image/png");
	                imagePart.setDataHandler(new DataHandler(dataSource));
	                imagePart.setFileName("Screenshot" + index + ".png");
	                multipart.addBodyPart(imagePart);
	                index++;
	            }
	        }	        

	        messageBodyPart.setContent(emailContent.toString(), "text/html");
	        message.setContent(multipart);

	        Transport.send(message);
	        System.out.println("Email Sent Successfully with Inline Screenshot!");
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println(" Email Sending Failed!");
	    }
	}
	
	

	public static void sendSummaryEmailWithScreenshots(WebDriver driver, String[] recipients, String subject, String message, List<String> failedUrls, List<byte[]> screenshotBytesList) throws MessagingException {

	    StringBuilder customMessage = new StringBuilder();
	    customMessage.append("<h2 style='color:blue;'>LR Automation Test Results</h2>");
	    customMessage.append("<h3>QA : <b>Pratiksha Ghodake</b></h3>");
	    customMessage.append("<p>").append(message).append("</p>");

	    if (!failedUrls.isEmpty()) {
	        customMessage.append("<b>Failed URLs:</b><br>");
	        for (String url : failedUrls) {
	            customMessage.append("<a href=\"").append(url).append("\" style='color:green;'>").append(url).append("</a><br>");
	        }
	    }

	    if (screenshotBytesList != null && !screenshotBytesList.isEmpty()) {
	        customMessage.append("<br><b>Attached Screenshots Below:</b><br>");
	    }

	    EmailUtility.sendEmailWithAttachment(subject, customMessage.toString(), recipients, screenshotBytesList);
	}
}


