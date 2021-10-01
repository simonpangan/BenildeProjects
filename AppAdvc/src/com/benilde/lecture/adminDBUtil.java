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

import com.benilde.lecture.controller.admincontroller;
import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;
import java.sql.Timestamp;

public class adminDBUtil {
	
	
	
	private static adminDBUtil instance;
	private static DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/javafinal";
	
	public static adminDBUtil getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new adminDBUtil();
		}
		
		return instance;
	}

	
	public adminDBUtil() throws Exception
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}

	public  List<Accounts> getUsers() throws Exception
	{
		List<Accounts> accounts = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			myConn = getConnection();
			String sql = "select * from accounts";
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			
			//process results
			while (myRs.next())
			{
				
				  int AccountID = myRs.getInt("AccountID");
				  String SchoolName = myRs.getString("SchoolName");
				  String firstname = myRs.getString("FirstName");
				  String middlename = myRs.getString("MiddleName");
				  String lastname= myRs.getString("LastName");
				  String UserType= myRs.getString("UserType");
				  int Age= myRs.getInt("Age");
				  String Address= myRs.getString("Address");
				  String TelNo= myRs.getString("TelNo");
				  String CelNo= myRs.getString("CelNo");
				  String Email= myRs.getString("Email");
				  String Password= myRs.getString("Password");
				  String AccountStatus= myRs.getString("AccountStatus");
				Timestamp CreationDate = myRs.getTimestamp("CreationDate");
				  Timestamp ModifiedDate = myRs.getTimestamp("ModifiedDate");
			
				  
					Accounts tempaccount;
					
				
					if(UserType.equals("Admin") || UserType.equals("Joiner")){
						tempaccount= new Accounts
								( AccountID,  firstname, middlename,  lastname,
								 UserType, Age,  Address,  TelNo,  CelNo
								, Email,  Password,  AccountStatus,CreationDate,ModifiedDate);
					}else{
						
						tempaccount= new Accounts( AccountID,  SchoolName,
									 UserType,  Address,  TelNo,  CelNo
									, Email,  Password,  AccountStatus, 
									CreationDate, ModifiedDate);
					}
						
			

			
		

				
				accounts.add(tempaccount);
			}
			
	
			
			return accounts;
			
		}
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}
	

	
	
	
	public String updateaccount(Accounts theaccount) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();
			
			

			String sql;
			
					if(theaccount.getUserType().equals("Admin") || theaccount.getUserType().equals("Joiner"))
			{
				 sql = "update accounts "
						+ " set FirstName=?, MiddleName=?, LastName=?"
						+ "  , Age=?, Address=?,"
						+ "  TelNo=?, CelNo=?, Email=?,"
						+ "  Password=?, AccountStatus=?, ModifiedDate=?"
						+ " where AccountID=?";
					
					
					myStmt = myConn.prepareStatement(sql);						
					myStmt.setString(1, theaccount.getFirstname());
					myStmt.setString(2, theaccount.getMiddlename());
					myStmt.setString(3, theaccount.getLastname());
					myStmt.setInt(4, theaccount.getAge());
					myStmt.setString(5, theaccount.getAddress());
					myStmt.setString(6, theaccount.getTelNo());
					myStmt.setString(7, theaccount.getCelNo());
					myStmt.setString(8, theaccount.getEmail());
					myStmt.setString(9, theaccount.getPassword());
					myStmt.setString(10, theaccount.getAccountStatus());
					Timestamp timestamp = new Timestamp(System.currentTimeMillis());
					myStmt.setTimestamp(11, timestamp);
					myStmt.setInt(12, theaccount.getAccountID());
					
				
					
					

					
					
			}else if(theaccount.getUserType().equals("School")){
				 sql = "update accounts "
							+ " set SchoolName=?, Address=?,"
							+ "  TelNo=?, CelNo=?, Email=?,"
							+ "  Password=?, AccountStatus=?, ModifiedDate=?"
							+ " where AccountID=?";
						
						
						myStmt = myConn.prepareStatement(sql);						
						myStmt.setString(1, theaccount.getSchoolname());
						myStmt.setString(2, theaccount.getAddress());
						myStmt.setString(3, theaccount.getTelNo());
						myStmt.setString(4, theaccount.getCelNo());
						myStmt.setString(5, theaccount.getEmail());
						myStmt.setString(6, theaccount.getPassword());
						myStmt.setString(7, theaccount.getAccountStatus());
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						myStmt.setTimestamp(8, timestamp);
						myStmt.setInt(9, theaccount.getAccountID());
			}
			
			
			admincontroller.setUsertype(null);
			
			myStmt.execute();
			
			return "Success";
		}
		finally {
			//close (myConn, myStmt);
		}
		
	}
	
	
	public  int[] getcountcategorie() throws Exception
	{
		
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		int[] temp = new int[8];
		try
		{
			myConn = getConnection();
			String sql = "SELECT Categorie, COUNT(*) "
					+ "FROM bootcamp GROUP BY Categorie";
			
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			

		
			while(myRs.next()){
				
				 if(myRs.getString("Categorie").equals("Full-Stack Web Development")){
					temp[0]= myRs.getInt("rowcount") ;
				}else if(myRs.getString("Categorie").equals("Mobile Development")){
					temp[1]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("Front-End Web Development")){
					temp[2]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("Data Science")){
					temp[3]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("UX Design")){
					temp[4]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("Digital Marketing")){
					temp[5]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("Product Management")){
					temp[6]= myRs.getInt("COUNT(*)") ;
				}else if(myRs.getString("Categorie").equals("Security")){
					temp[7]= myRs.getInt("COUNT(*)") ;
				}
			}
		}
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
		return temp;
	}
	
	public String addAccount(Accounts theaccount) throws Exception {
			
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			
			
			try{
				myConn = getConnection();
				
				String sql;
				if(theaccount.getUserType().equals("Admin"))
				{
					 sql = "insert into  accounts (FirstName,MiddleName,LastName,UserType,"
								+ "Age,Address,TelNo,CelNo,"
								+ "Email,Password,AccountStatus,CreationDate) "
								+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
						
						
						myStmt = myConn.prepareStatement(sql);						
						myStmt.setString(1, theaccount.getFirstname());
						myStmt.setString(2, theaccount.getMiddlename());
						myStmt.setString(3, theaccount.getLastname());
						myStmt.setString(4, theaccount.getUserType());
						myStmt.setInt(5, theaccount.getAge());
						myStmt.setString(6, theaccount.getAddress());
						myStmt.setString(7, theaccount.getTelNo());
						myStmt.setString(8, theaccount.getCelNo());
						myStmt.setString(9, theaccount.getEmail());
						myStmt.setString(10, Helper.encryptThisString(theaccount.getPassword()));
						myStmt.setString(11, theaccount.getAccountStatus());
						
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						
						
						
						myStmt.setTimestamp(12, timestamp);
						//  java.sql.Date date = getCurrentDatetime();
				}else if(theaccount.getUserType().equals("School")){
					 sql = "insert into  accounts (SchoolName,UserType,"
								+ "Address,TelNo,CelNo,"
								+ "Email,Password,AccountStatus,CreationDate) "
								+ "values (?,?,?,?,?,?,?,?,?)";
						
						
						myStmt = myConn.prepareStatement(sql);
	
						myStmt.setString(1, theaccount.getSchoolname());
						myStmt.setString(2, theaccount.getUserType());
						myStmt.setString(3, theaccount.getAddress());
						myStmt.setString(4, theaccount.getTelNo());
						myStmt.setString(5, theaccount.getCelNo());
						myStmt.setString(6, theaccount.getEmail());
						myStmt.setString(7, Helper.encryptThisString(theaccount.getPassword()));
						myStmt.setString(8, theaccount.getAccountStatus());
						
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
						
						
						
						myStmt.setTimestamp(9, timestamp);
						//  java.sql.Date date = getCurrentDatetime();
				}
				
				admincontroller.setUsertype(null);
				
				myStmt.execute();
				
				return "Success";
			}
			
			finally
			{
				//clean up JDBC objects
			//	close(myConn, myStmt);
			}
			
		}	

	public  Accounts getAccount(int accountID) throws Exception {
			
			Connection myConn = null;
			PreparedStatement myStmt = null;
			ResultSet myRs = null;
			

			try {
				myConn = getConnection();
	
				String sql = "select * from accounts where AccountID=?";
	
				myStmt = myConn.prepareStatement(sql);
				
				// set params
				myStmt.setInt(1, accountID);
				
				myRs = myStmt.executeQuery();
	
			
				Accounts theaccount = null;
				
				// retrieve data from result set row
				if (myRs.next()) {
					
					  int AccountID = myRs.getInt("AccountID");
					  String SchoolName = myRs.getString("SchoolName");
					  String firstname = myRs.getString("FirstName");
					  String middlename = myRs.getString("MiddleName");
					  String lastname= myRs.getString("LastName");
					  String UserType= myRs.getString("UserType");
					  int Age= myRs.getInt("Age");
					  String Address= myRs.getString("Address");
					  String TelNo= myRs.getString("TelNo");
					  String CelNo= myRs.getString("CelNo");
					  String Email= myRs.getString("Email");
					  String Password= Helper.encryptThisString(myRs.getString("Password"));
					  String AccountStatus= myRs.getString("AccountStatus");
					Timestamp CreationDate = myRs.getTimestamp("CreationDate");
					  Timestamp ModifiedDate = myRs.getTimestamp("ModifiedDate");
				
					  
						Accounts tempaccount;
						
					
						if(UserType.equals("Admin") || UserType.equals("Joiner")){
							tempaccount= new Accounts
									( AccountID,  firstname, middlename,  lastname,
									 UserType, Age,  Address,  TelNo,  CelNo
									, Email,  Password,  AccountStatus,CreationDate,ModifiedDate);
						}else{
							
							tempaccount= new Accounts( AccountID,  SchoolName,
										 UserType,  Address,  TelNo,  CelNo
										, Email,  Password,  AccountStatus, 
										CreationDate, ModifiedDate);
						}
							
				

						return tempaccount;
			
				
					
				}
				else {
					throw new Exception("Could not find  accounidid: " + accountID);
				}
				
			
			}
			finally {
				close (myConn, myStmt, myRs);
			}
		}
	
	
	
	
	public void deleteaccount(int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from accounts where AccountID = ?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);
			
			myStmt.execute();
		}
		finally {
			//close (myConn, myStmt);
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



	
}
