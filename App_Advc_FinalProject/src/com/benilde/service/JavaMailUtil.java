package com.benilde.service;


import java.util.Properties;
import  javax.mail.Authenticator;
import javax.mail.Message;
import  javax.mail.PasswordAuthentication;
import  javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class JavaMailUtil {
	
	
	public static void sendMail(String recepient){
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		
		String myAccountEmail = "xxxxx@gmail.com";
		String password = "xxxxxxxx";
		
		Session session = Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication(myAccountEmail,password);
			}
			
			
		});
		
		Message message  = prepareMessage(session,myAccountEmail,recepient );
		
		Transport.send(message);	
	}

	private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
		
		try{
			Message message = new MimeMessage(session); 
			
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipient(Message.RecipientType.TO, new  InternetAddress(recepient));
			message.setSubject("My first email");
			message.setText("HELO!!!");
			
			return message;
		}catch (Exception ex){
			Logger.getLogger(JavaMailUtil.class.getName().log(Level.SEVERE,null,ex));
		}
		
		
		return null;
	}

}
