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

public class ProjDBUtil {
	
	
	
	private static ProjDBUtil instance;
	private static DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/javafinal";
	
	public static ProjDBUtil getInstance() throws Exception
	{
		if(instance == null)
		{
			instance = new ProjDBUtil();
		}
		
		return instance;
	}

	
	public ProjDBUtil() throws Exception
	{
		dataSource = getDataSource();
	}
	
	private DataSource getDataSource() throws NamingException
	{
		Context context = new InitialContext();
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		return theDataSource;
	}
	
	
	
	

		
	
	
	
	public int[] infoList() throws Exception
	{
		 int temp[] = new int[6]; 
		 
			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			try
			{
			
				myConn = getConnection();
				String sql = "SELECT * FROM `accounts`";
				
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery(sql);
				
				int temp1 = 0;
				int temp2 = 0;
				int temp3 = 0;
				int temp4 =0;
				int temp5 =0;
				int temp6 =0;
				while (myRs.next())
				{
					if(myRs.getString("UserType").equals("Admin")){
						 temp1++;
						 
						if(myRs.getString("AccountStatus").equals("Active")){
							 temp4++;					
						
						}
						 
						 
					}else if(myRs.getString("UserType").equals("School")){
						temp2++;
						
							if(myRs.getString("AccountStatus").equals("Active")){
								temp5++;
						}
						
					}else if (myRs.getString("UserType").equals("Joiner")){
						temp3++;
							if(myRs.getString("AccountStatus").equals("Active")){
								temp6++;
						}
					}
					 
				}
				
	
				System.out.println(temp1);
				temp[0] = temp1;
				temp[1] = temp2;
				temp[2] = temp3;
				temp[3] = temp4;
				temp[4] = temp5;
				temp[5] = temp6;
			}
			
			finally
			{
				//clean up JDBC objects
				close(myConn, myStmt, myRs);
			}
		 
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	public java.sql.Date getCurrentDatetime() {
	    java.util.Date today = new java.util.Date();
	    LocalDateTime now = LocalDateTime.now();  
	    return new java.sql.Date(today.getTime());
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
