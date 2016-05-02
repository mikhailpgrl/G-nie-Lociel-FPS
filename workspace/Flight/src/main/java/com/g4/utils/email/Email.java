package com.g4.utils.email;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

<<<<<<< HEAD
import com.g4.beans.Flight;

=======
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8

public class Email {

	public static final String username = "y.kiracagalli@gmail.com";
	public static final String password = "flight123";
	
<<<<<<< HEAD
	public static void sendEmailOfp(List<Flight> lflight){
		  // Recipient's email ID needs to be mentioned.
	      String to = "y.kiracagalli@gmail.com";//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = username;//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	    	  
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("OFP Missing");

	         // Now set the actual message
	         String mes = "OFP Missing : \n";
	         //« numéro commercial » / « date » / « aéroport de départ »
	         for (Flight flight : lflight) {
				mes += "   Commercial number:" + flight.getCommercial_number() + "    Date:" +
						flight.getDeparture_date() + " " + flight.getDeparture_time() + "    Airport:" +
						flight.getDeparture_airport() + "\n";
			}
	         message.setText(mes);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }
	
	
	
	public static void sendEmailCrew(List<Flight> lflight){
		  // Recipient's email ID needs to be mentioned.
	      String to = "y.kiracagalli@gmail.com";//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = username;//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	    	  
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Flight incomplete");

	         // Now set the actual message
	         String mes = "Flight incomplete : \n";
	         //« numéro commercial » / « date » / « aéroport de départ »
	         for (Flight flight : lflight) {
				mes += "   Commercial number:" + flight.getCommercial_number() + "    Date:" +
						flight.getDeparture_date() + " " + flight.getDeparture_time() + "    Airport:" +
						flight.getDeparture_airport() + "\n";
			}
	         message.setText(mes);

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
	   }
	
	
	
	
	public void sendEmail(){
		  // Recipient's email ID needs to be mentioned.
	      String to = "y.kiracagalli@gmail.com";//change accordingly

	      // Sender's email ID needs to be mentioned
	      String from = username;//change accordingly

	      // Assuming you are sending email through relay.jangosmtp.net
	      String host = "smtp.gmail.com";

	      Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", host);
	      props.put("mail.smtp.port", "587");

	      // Get the Session object.
	      Session session = Session.getInstance(props,
	      new javax.mail.Authenticator() {
	         protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	         }
	      });

	      try {
	         // Create a default MimeMessage object.
	    	  
	         Message message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.setRecipients(Message.RecipientType.TO,
	         InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject("Testing Subject");

	         // Now set the actual message
	         message.setText("Hello, this is sample for to check send "
	            + "email using JavaMailAPI ");

	         // Send message
	         Transport.send(message);

	         System.out.println("Sent message successfully....");

	      } catch (MessagingException e) {
	            throw new RuntimeException(e);
	      }
=======
	public void sendEmail(){
//		  // Recipient's email ID needs to be mentioned.
//	      String to = "alexandre_110693@hotmail.fr";//change accordingly
//
//	      // Sender's email ID needs to be mentioned
//	      String from = username;//change accordingly
//
//	      // Assuming you are sending email through relay.jangosmtp.net
//	      String host = "smtp.gmail.com";
//
//	      Properties props = new Properties();
//	      props.put("mail.smtp.auth", "true");
//	      props.put("mail.smtp.starttls.enable", "true");
//	      props.put("mail.smtp.host", host);
//	      props.put("mail.smtp.port", "587");
//
//	      // Get the Session object.
//	      Session session = Session.getInstance(props,
//	      new javax.mail.Authenticator() {
//	         protected PasswordAuthentication getPasswordAuthentication() {
//	            return new PasswordAuthentication(username, password);
//	         }
//	      });
//
//	      try {
//	         // Create a default MimeMessage object.
//	    	  
//	         Message message = new MimeMessage(session);
//
//	         // Set From: header field of the header.
//	         message.setFrom(new InternetAddress(from));
//
//	         // Set To: header field of the header.
//	         message.setRecipients(Message.RecipientType.TO,
//	         InternetAddress.parse(to));
//
//	         // Set Subject: header field
//	         message.setSubject("Testing Subject");
//
//	         // Now set the actual message
//	         message.setText("Hello, this is sample for to check send "
//	            + "email using JavaMailAPI ");
//
//	         // Send message
//	         Transport.send(message);
//
//	         System.out.println("Sent message successfully....");
//
//	      } catch (MessagingException e) {
//	            throw new RuntimeException(e);
//	      }
>>>>>>> 7dbf05ef84452a22ad3fc0f8dd905b599a1d4bc8
	   }
	}
