package com.benilde.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.activation.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import java.math.BigInteger; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;

import com.benilde.lecture.controller.admincontroller;
import com.benilde.lecture.model.Accounts;

public class Helper {
	
	private static String jndiName = "java:comp/env/jdbc/javafinal";
	private static DataSource dataSource;
	
	
		public Helper() throws Exception{
		
		
		}
		
		public static void changestatus (String email) throws Exception {
			

			Connection myConn = null;
			PreparedStatement myStmt = null;

			try {
				myConn = getConnection();
				
				

				String	sql = "update accounts set AccountStatus=?  where Email=?";
						
						
						myStmt = myConn.prepareStatement(sql);						
						myStmt.setString(1, "Active");
						myStmt.setString(2, email);
						
						

					
							myStmt.execute();
			}
			finally {
				//close (myConn, myStmt);
			}
		}
		
		  public static boolean verification (String email, String code) throws Exception {
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				dataSource = getDataSource();
				
			
				try {
					myConn = getConnection();
		
					String sql = "select * from accounts where Email=? AND UniqueIdentifier=?";
		
					myStmt = myConn.prepareStatement(sql);
					
					// set params
					myStmt.setString(1,email);
					myStmt.setString(2,code);
					
					myRs = myStmt.executeQuery();
		
		
					return (myRs.next()) ? true: false;
					
				
				}
				finally {
					close (myConn, myStmt, myRs);
				}
			}
		  
		
		
		  public static int id (String email) throws Exception {
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				dataSource = getDataSource();
				
			
				try {
					myConn = getConnection();
		
					String sql = "select * from accounts where Email=? ";
		
					myStmt = myConn.prepareStatement(sql);
					
					// set params
					myStmt.setString(1,email);
					
					myRs = myStmt.executeQuery();
		
		
					int temp = 0;
					if(myRs.next())
					{
						 temp = myRs.getInt("AccountID");
					}
					return  temp;
					
				
				}
				finally {
					close (myConn, myStmt, myRs);
				}
			}
		  
		
		  public static String usertype(String email) throws Exception {
				
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				dataSource = getDataSource();
				
			
				try {
					myConn = getConnection();
		
					String sql = "select * from accounts where Email=? ";
		
					myStmt = myConn.prepareStatement(sql);
					
					// set params
					myStmt.setString(1,email);
					
					myRs = myStmt.executeQuery();
		
		
					String temp = null;
					if(myRs.next())
					{
						 temp = myRs.getString("UserType");
					}
					return  temp;
					
				
				}
				finally {
					close (myConn, myStmt, myRs);
				}
			}
	
		
	  public static boolean checkforacc(String email,String Password) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			dataSource = getDataSource();
			
			try {
				myConn = getConnection();
	
				String sql = "select * from accounts where Email=? and Password=?";
	
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setString(1,email);
				myStmt.setString(2,Password);
				
				myRs = myStmt.executeQuery();
	
				
			
				 
	
				return (myRs.next()) ? true: false;
			
			}
			finally {
				close (myConn, myStmt, myRs);
			}
		}
	
	
	  public static String checkforstatis(String email) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			dataSource = getDataSource();
			
			try {
				myConn = getConnection();
	
				String sql = "select * from accounts where Email=?";
	
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setString(1,email);
			
				myRs = myStmt.executeQuery();
	
				myRs.next();
	
				return   myRs.getString("AccountStatus");
			
			}
			finally {
				close (myConn, myStmt, myRs);
			}
		}
	
	  
	
	public static String encryptThisString(String input) 
    { 
		input = input + "joincodershub";
        try { 
            // getInstance() method is called with algorithm SHA-512 
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
  
            // digest() method is called 
            // to calculate message digest of the input string 
            // returned as array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
  
            // Add preceding 0s to make it 32 bit 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
  
            // return the HashText 
            return hashtext; 
        } 
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 

	 static String getAlphaNumericString(int n) 
	    { 
	  
	        // chose a Character random from this String 
	        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                                    + "0123456789"
	                                    + "abcdefghijklmnopqrstuvxyz"; 
	  
	        // create StringBuffer size of AlphaNumericString 
	        StringBuilder sb = new StringBuilder(n); 
	  
	        for (int i = 0; i < n; i++) { 
	  
	            // generate a random number between 
	            // 0 to AlphaNumericString variable length 
	            int index 
	                = (int)(AlphaNumericString.length() 
	                        * Math.random()); 
	  
	            // add Character one by one in end of sb 
	            sb.append(AlphaNumericString 
	                          .charAt(index)); 
	        } 
	  
	        return sb.toString(); 
	    } 
	  
	
		 public static void Mail(String email,String subject,String messager) {
	
		     final String username = "joincodershub@gmail.com";
		     final String password = "paushielasimonlesley";
		
		     Properties props = new Properties();
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.smtp.ssl.enable", "true");
		     props.put("mail.smtp.host", "smtp.gmail.com");
		     props.put("mail.smtp.port", "465");
		
		     Session session = Session.getInstance(props,
		       new javax.mail.Authenticator() {
		         protected PasswordAuthentication getPasswordAuthentication() {
		             return new PasswordAuthentication(username, password);
		         }
		       });
		
		     try {
		
		
		         Message message = new MimeMessage(session);
		         message.setFrom(new InternetAddress(email));
		         message.setRecipients(Message.RecipientType.TO,
		             InternetAddress.parse(email));
		         message.setSubject(subject);
		         message.setText(messager);
		
		         Transport.send(message);
		
		         System.out.println("Done");
		
		     } catch (MessagingException e) {
		         throw new RuntimeException(e);
		     }
		 }
	 	 
		 
		 
		 static Connection getConnection() throws Exception {

			Connection theConn = dataSource.getConnection();
			
			return theConn;
		}
		
	 	  static void close(Connection theConn, Statement theStmt, ResultSet theRs) {

			try {
				if (theRs != null) {
					theRs.close();
				}

				if (theStmt != null) {
					theStmt.close();
				}

				if (theConn != null) {
					theConn.close();
				}
				
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	 		static DataSource getDataSource() throws NamingException
			{
				Context context = new InitialContext();
				DataSource theDataSource = (DataSource) context.lookup(jndiName);
				return theDataSource;
			}
			
}


	 
	 

