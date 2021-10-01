package com.benilde.lecture;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;
import java.sql.Timestamp;

public class joinerDBUtil {
	
	
	
	private static joinerDBUtil instance;
	private static DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/javafinal";
	
	public static joinerDBUtil getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new joinerDBUtil();
		}
		
		return instance;
	}

	
	public joinerDBUtil() throws Exception
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}
	
	
	public List<bootcamp> myboot(int temp) throws Exception{
	List<bootcamp> bootcamp = new ArrayList<>();
		
		Connection myConn = null;
		ResultSet myRs = null;
		Statement myStmt = null;
		try
		{
			
		
			myConn = getConnection();
		
			
			String sql = 
					"SELECT * FROM bootcamp INNER JOIN joinerslist ON bootcamp.bootcampID"+ 
					"= joinerslist.bootcampID WHERE joinerslist.AccountID ="+ temp;
					
	
			myStmt =myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);

		
		
			bootcamp  tempboot = null;
			
			//process results
			while (myRs.next())
			{
		
				 int bootcampID= myRs.getInt("bootcampID");
				 int SchoolID= myRs.getInt("SchoolID");
				 String BootcampName = myRs.getString("BootcampName");
				 String BootcampDetails = myRs.getString("BootcampDetails");
				 String ClassDays = myRs.getString("ClassDays");
				 String Venue = myRs.getString("Venue");
				 String Categorie = myRs.getString("Categorie");
				 String Status = myRs.getString("EnrollmentStatus");
				 Timestamp CreationDate = myRs.getTimestamp("CreationDate");
				 Timestamp ModifiedDate = myRs.getTimestamp("ModifiedDate"); 
				 int slots = myRs.getInt("MaximumSlot");
					//create student object
				 
				
				 
				 
				 String query = "select count(*) AS rowcount from joinerslist where bootcampID= " + bootcampID;
				 
				 
				 Statement s = myConn.createStatement();
				 ResultSet r = s.executeQuery(query);
				 r.next();
				 int count = r.getInt("rowcount") ;
				 r.close() ;
				 
			     
			    int slotsleft = slots - count;
			    
			    
				
				 tempboot = new bootcamp(bootcampID,  SchoolID, 
						  BootcampName, BootcampDetails, Status,
			 slots, slotsleft,  ClassDays,   Venue, Categorie , CreationDate,  ModifiedDate);
				 
				 bootcamp.add(tempboot);
				 
			}
				
			
			return bootcamp;
			
		}
		
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	

	}
	
	public void requestjoin(int bootcampid,int userid) throws Exception{
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
			myConn = getConnection();
			
			String sql = "insert into  joinerslist (bootcampID,"
					+ "AccountID,EnrollmentStatus)"
					+ " values (?,?,?)";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, bootcampid);
			myStmt.setInt(2, userid);
			myStmt.setString(3, "Pending");

			myStmt.execute();
			
		}
		
		finally
		{
			//clean up JDBC objects
		//	close(myConn, myStmt);
		}
			
	}
	
	public void addAccountJoiner(Accounts theaccount) throws Exception {
			
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
			myConn = getConnection();
			
			String sql = "insert into  accounts (FirstName,"
					+ "MiddleName,LastName,UserType,"
					+ "Age,Address,TelNo,CelNo,Email,"
					+ "Password,AccountStatus,UniqueIdentifier,CreationDate)"
					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setString(1, theaccount.getFirstname());
			myStmt.setString(2, theaccount.getMiddlename());
			myStmt.setString(3, theaccount.getLastname());
			myStmt.setString(4, "Joiner");
			myStmt.setInt(5, theaccount.getAge());
			myStmt.setString(6, theaccount.getAddress());
			myStmt.setString(7, theaccount.getTelNo());
			myStmt.setString(8, theaccount.getCelNo());
			myStmt.setString(9, theaccount.getEmail());
			myStmt.setString(10, Helper.encryptThisString(theaccount.getPassword()));
			myStmt.setString(11, "Inactive");
	
			
		
			String temp = Helper.getAlphaNumericString(36);
	        
			String message = "Hello " + theaccount.getFirstname() 
			+ " " + theaccount.getLastname() + ". You have successfully register your account. "
			+ "Please use this code to verify your account : "  + temp;
			
			
			myStmt.setObject(12, temp);
			
		
			Helper.Mail(theaccount.getEmail(),"Account Verification",message );
			  
			
		
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			
			myStmt.setTimestamp(13, timestamp);
			
			myStmt.execute();
			
		}
		
		finally
		{
			//clean up JDBC objects
		//	close(myConn, myStmt);
		}
		
	}	
	
	
	public List<bootcamp> getAllbootcamp(int id) throws Exception
	{
		List<bootcamp> bootcamp = new ArrayList<>();
		
		Connection myConn = null;
		ResultSet myRs = null;
		Statement myStmt = null;
		try
		{
			
		
			myConn = getConnection();
		
			
			String sql = "SELECT * FROM `bootcamp` WHERE bootcampID NOT IN "
					+ "( SELECT bootcampID FROM `joinerslist` WHERE AccountID =" +id +")";
			
			myStmt =	myConn.createStatement();
			
			myRs = myStmt.executeQuery(sql);
			
			
		

		
		
			bootcamp  tempboot = null;
			
			//process results
			while (myRs.next())
			{
		

				  System.out.println("HELLO");

				 int bootcampID= myRs.getInt("bootcampID");
				 int AccountID= myRs.getInt("SchoolID");
				 String BootcampName = myRs.getString("BootcampName");
				 String BootcampDetails = myRs.getString("BootcampDetails");
				 String ClassDays = myRs.getString("ClassDays");
				 String Venue = myRs.getString("Venue");
				 String Categorie = myRs.getString("Categorie");
				 String Status = myRs.getString("Status");
				 Timestamp CreationDate = myRs.getTimestamp("CreationDate");
				 Timestamp ModifiedDate = myRs.getTimestamp("ModifiedDate"); 
				 int slots = myRs.getInt("MaximumSlot");
					//create student object
				 
				
				 
				 
				 String query = "select count(*) AS rowcount from joinerslist where bootcampID= " + bootcampID;
				 
				 
				 Statement s = myConn.createStatement();
				 ResultSet r = s.executeQuery(query);
				 r.next();
				 int count = r.getInt("rowcount") ;
				 r.close() ;
				 
			     
			    int slotsleft = slots - count;
			    
			    
				
				 tempboot = new bootcamp(bootcampID,  AccountID, 
						  BootcampName, BootcampDetails, Status,
			 slots, slotsleft,  ClassDays,   Venue, Categorie , CreationDate,  ModifiedDate);
				 
				 bootcamp.add(tempboot);
				 
			}
				
			
			return bootcamp;
			
		}
		
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	

	}
	
	
	
	
	
	
	
	public  bootcamp getBootcampDetail(int id) throws Exception {
			
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		

		try {
			myConn = getConnection();

			String sql = "select * from bootcamp where bootcampID=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, id);
			
			myRs = myStmt.executeQuery();
			
			 bootcamp tempboot = null;
			//process results
			while (myRs.next())
			{
		

				 int bootcampID= myRs.getInt("bootcampID");
				 int AccountID= myRs.getInt("SchoolID");
				 String BootcampName = myRs.getString("BootcampName");
				 String BootcampDetails = myRs.getString("BootcampDetails");
				 String ClassDays = myRs.getString("ClassDays");
				 String Venue = myRs.getString("Venue");
				 String Categorie = myRs.getString("Categorie");
				 String Status = myRs.getString("Status");
				 Timestamp CreationDate = myRs.getTimestamp("CreationDate");
				 Timestamp ModifiedDate = myRs.getTimestamp("ModifiedDate"); 
			
					//create student object
				 int slots = myRs.getInt("MaximumSlot");

				 
				 String query = "select count(*) AS rowcount from joinerslist where bootcampID= " + bootcampID;
				 
				 
				 Statement s = myConn.createStatement();
				 ResultSet r = s.executeQuery(query);
				 r.next();
				 int count = r.getInt("rowcount") ;
				 r.close() ;
				 
			     
			    int slotsleft = slots - count;
			    
				 tempboot = new bootcamp(bootcampID,  AccountID, 
						  BootcampName, BootcampDetails, Status,slotsleft,
			 slots,  ClassDays,   Venue, Categorie , CreationDate,  ModifiedDate);
				 
				 return tempboot;
			}
				
			return null;
		}
		
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}
	

	
	
		
	private static Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private static void close(Connection theConn, Statement theStmt, ResultSet theRs) {

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



	
}
