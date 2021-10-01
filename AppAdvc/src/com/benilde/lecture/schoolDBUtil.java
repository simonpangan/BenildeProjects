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

public class schoolDBUtil {
	
	
	
	private static schoolDBUtil instance;
	private static DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/javafinal";
	
	public static schoolDBUtil getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new schoolDBUtil();
		}
		
		return instance;
	}

	
	public schoolDBUtil() throws Exception
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}
	
	    

	public void updatestatus(int id, int bootcampid) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
				myConn = getConnection();

				
				String sql1 = "select * from joinerslist where AccountID=? AND bootcampID=?";

				myStmt = myConn.prepareStatement(sql1);
				
				// set params
				myStmt.setInt(1, id);
				myStmt.setInt(2, bootcampid);
				
				myRs = myStmt.executeQuery();
				
				String temp = null;
				if (myRs.next())
				{
			
				
					temp = myRs.getString("EnrollmentStatus");
		
				}
				
				
				//-------
				
				
				String	sql = "update  joinerslist "
					+ " set EnrollmentStatus=?"
					+ " where AccountID=? AND bootcampID=?";
				
				
				myStmt = myConn.prepareStatement(sql);	
				
				if(temp.equals("Paid"))
				{
					myStmt.setString(1, "Pending");
				}else{
					myStmt.setString(1, "Paid");
				}
			
				myStmt.setInt(2, id);
				
				myStmt.setInt(3	, bootcampid);
				
				myStmt.execute();
		}
		finally {
			//close (myConn, myStmt);
		}
		
	}
	
	public void updatebootcamp(bootcamp thebootcamp) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

				String	sql = "update  bootcamp "
					+ " set BootcampName=?, BootcampDetails=?, Status=?"
					+ "  , ClassDays=?, Venue=?,"
					+ "  Categorie=?, ModifiedDate=?,MaximumSlot=?"
					+ " where bootcampID=?";
				
				
				myStmt = myConn.prepareStatement(sql);						
				myStmt.setString(1, thebootcamp.getBootcampName());
				myStmt.setString(2, thebootcamp.getBootcampDetails());
				myStmt.setString(3, thebootcamp.getStatus());
				myStmt.setString(4, thebootcamp.getClassDays());
				myStmt.setString(5, thebootcamp.getVenue());
				myStmt.setString(6, thebootcamp.getCategorie());
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				myStmt.setTimestamp(7, timestamp);
				myStmt.setInt(8, thebootcamp.getSlots());
		
				myStmt.setInt(9, thebootcamp.getBootcampID());
			
				myStmt.execute();
		}
		finally {
			//close (myConn, myStmt);
		}
		
	}
	
	public bootcamp getBootcampsinfo(int id) throws Exception
	{
		
		
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
				 int slotsleft = slots;
				 tempboot = new bootcamp(bootcampID,  AccountID, 
						  BootcampName, BootcampDetails, Status,slotsleft,
			 slots,  ClassDays,   Venue, Categorie , CreationDate,  ModifiedDate);
				 
				 return tempboot;
			}
				
			//return tempboot;
			return null;
		}
		
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	

		
	}
	
	public int[] getbootcampjoinersinfo(int id) throws Exception
	{
		
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		int[] temp = new int[3];
		try {
			myConn = getConnection();

			String sql1 = "select * from joinerslist where bootcampID=?";

			myStmt = myConn.prepareStatement(sql1);
			
			// set params
			myStmt.setInt(1, id);
			
			myRs = myStmt.executeQuery();
			

			int temp1 =0;
			 int temp2 = 0;
			 int temp3 = 0;
			while (myRs.next())
			{
				temp1++;
				 if(myRs.getString("EnrollmentStatus").equals("Pending")){
					 temp2++;
				 }else{
					 temp3++;
				 }
			}
			
			temp[0] = temp1;
			temp[1] = temp2;
			temp[2] = temp3;
			
		
				
			//return tempboot;
			return temp;
		}
		
		
		finally
		{
			//clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	

		
	}

	@SuppressWarnings("null")
	public List<bootcamp> getBootcamps(int id) throws Exception
	{
		List<bootcamp> bootcamp = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		
		try
		{
			
		
			myConn = getConnection();
		
			
			String sql = "select * from bootcamp where SchoolID=?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, 5);
			
			myRs = myStmt.executeQuery();

		
		
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
	
	public void addBootcamp(bootcamp thebootcamp) throws Exception {
		
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		
		try{
			myConn = getConnection();
			
			String sql = "insert into  bootcamp (SchoolID,BootcampName,"
					+ "BootcampDetails,Status,ClassDays,"
					+ "Venue,Categorie,CreationDate,MaximumSlot)"
					+ " values (?,?,?,?,?,?,?,?,?)";
			
			
			myStmt = myConn.prepareStatement(sql);
			
			myStmt.setInt(1, thebootcamp.getAccountID());
			myStmt.setString(2, thebootcamp.getBootcampName());
			myStmt.setString(3, thebootcamp.getBootcampDetails());
			myStmt.setString(4, thebootcamp.getStatus());
			myStmt.setString(5, thebootcamp.getClassDays());
			myStmt.setString(6, thebootcamp.getVenue());
			myStmt.setString(7, thebootcamp.getCategorie());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			myStmt.setTimestamp(8, timestamp);
			myStmt.setInt(9, thebootcamp.getSlots());
			myStmt.execute();
			
		}
		
		finally
		{
			//clean up JDBC objects
		//	close(myConn, myStmt);
		}
		
	}	
	
	
	public void deletebootcamp(int id) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from bootcamp where bootcampID = ?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);
			
			myStmt.execute();
		}
		finally {
			//close (myConn, myStmt);
		}		
	}
	
	
	public void deleteajoiner(int id, int bootcampid) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from joinerslist where AccountID = ? AND bootcampID=?" ;

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, id);
			myStmt.setInt(2, bootcampid);
			
			myStmt.execute();
		}
		finally {
			//close (myConn, myStmt);
		}		
	}
	
	
	

	public  List<Accounts> getUsers(int id) throws Exception
	{
		List<Accounts> accounts = new ArrayList<>();
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try
		{
			myConn = getConnection();
			String sql   //= "select * from accounts where";
	="SELECT * FROM accounts INNER JOIN joinerslist ON "
			+ "joinerslist.AccountID = accounts.AccountID where bootcampID =?";
			
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, id);
			
			myRs = myStmt.executeQuery();

			//process results
			while (myRs.next())
			{
				  int AccountID = myRs.getInt("AccountID");
				  String firstname = myRs.getString("FirstName");
				  String middlename = myRs.getString("MiddleName");
				  String lastname= myRs.getString("LastName");

				  int Age= myRs.getInt("Age");
				  String Address= myRs.getString("Address");
				  String TelNo= myRs.getString("TelNo");
				  String CelNo= myRs.getString("CelNo");
				  String Email= myRs.getString("Email");
				
				  String EnrollmentStatus= myRs.getString("EnrollmentStatus");
				
				  
				//  String CreationDate = myRs.getTimestamp("CreationDate");
			//	  String ModifiedDate = myRs.getTimestamp("ModifiedDate");
			
				  
				//create student object
				Accounts tempaccount = new Accounts
						( AccountID,  firstname, middlename,  lastname, 
						 Age,  Address,  TelNo,  CelNo
						, Email,   EnrollmentStatus);
				
				//add it to the list of students
			
		
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
