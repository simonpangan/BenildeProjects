package com.benilde.entity;


import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.benilde.service.DB_connection;





@ManagedBean
@SessionScoped
public class AccountRegister {
	
	
	public AccountRegister(){
		role = "";
	}
	
	private String FirstName;
	private String LastName;
	private String email;

	private String MiddleName;
	private String role;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	public void register(){
	    try {
	        Connection connection=null;
	        DB_connection obj_DB_connection=new DB_connection();
	        connection=obj_DB_connection.get_connection();
	     
	        String query ="";
	        
	        if(role.equals("Joiners")){
	        	   query = " insert into joiners (FirstName, LastName, MiddleName)"
	  			        + " values (?, ?, ?)";

	        }else if(role.equals("Organizers")){
	        	   query = " insert into organizers (FirstName, LastName)"
		  			        + " values (?, ?)";
	        }
	      
			      // create the mysql insert preparedstatement
	   PreparedStatement preparedStmt = connection.prepareStatement(query);
	   
			      preparedStmt.setString(1, FirstName);
			      preparedStmt.setString(2, LastName);
			      
			      if(role.equals("Joiners"))    
			      preparedStmt.setString(3, MiddleName);
		
			      
			      preparedStmt.execute();
			      connection.close();
			      
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	
	
	public boolean getConditionjoiners(){
		
	
	String check = new String(role);

	
	boolean condition = check.equals("Joiners");

		
		return condition;
	
		
	}
	

	
	public Boolean getConditionorganizers(){
		
		String check = new String(role);

		
		boolean condition = check.equals("Organizers");

			
			return condition;
		
		
	}
	public String  pageRedirect(){
	  
		
		return "admin.xhtml";
	}
	

}
