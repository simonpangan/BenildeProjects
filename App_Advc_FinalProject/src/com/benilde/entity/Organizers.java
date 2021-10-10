package com.benilde.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.benilde.service.DB_connection;

@ManagedBean
public class Organizers {
	
	private int OrganizerID;
	private String Email;
	private String Password;
	private String Contact;
	private String FirstName;
	private String LastName;
	private String MiddleName;
	private String ExtensionName;
	private int Age;
	private String Birthdate;
	private String Address;
	private String Username;
	private String IDtype;
	private int IDnumber;
	private String AccountStatus;
		
	
	
	

	  public int getOrganizerID() {
		return OrganizerID;
	}





	public void setOrganizerID(int organizerID) {
		OrganizerID = organizerID;
	}





	public String getEmail() {
		return Email;
	}





	public void setEmail(String email) {
		Email = email;
	}





	public String getPassword() {
		return Password;
	}





	public void setPassword(String password) {
		Password = password;
	}





	public String getContact() {
		return Contact;
	}





	public void setContact(String contact) {
		Contact = contact;
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





	public String getExtensionName() {
		return ExtensionName;
	}





	public void setExtensionName(String extensionName) {
		ExtensionName = extensionName;
	}





	public int getAge() {
		return Age;
	}





	public void setAge(int age) {
		Age = age;
	}





	public String getBirthdate() {
		return Birthdate;
	}





	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}





	public String getAddress() {
		return Address;
	}





	public void setAddress(String address) {
		Address = address;
	}





	public String getUsername() {
		return Username;
	}





	public void setUsername(String username) {
		Username = username;
	}





	public String getIDtype() {
		return IDtype;
	}





	public void setIDtype(String iDtype) {
		IDtype = iDtype;
	}





	public int getIDnumber() {
		return IDnumber;
	}





	public void setIDnumber(int iDnumber) {
		IDnumber = iDnumber;
	}





	public String getAccountStatus() {
		return AccountStatus;
	}





	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}





	public ArrayList<Organizers> getGet_all_Organizers() throws Exception{
	        ArrayList<Organizers> list_of_Organizers=new ArrayList<Organizers>();
	             Connection connection=null;
	        try {
	            DB_connection obj_DB_connection=new DB_connection();
	            connection=obj_DB_connection.get_connection();
	            Statement st=connection.createStatement();
	            ResultSet rs=st.executeQuery("select * from organizers");
	            while(rs.next()){
	            	
	            	Organizers obj_Joiners =new Organizers();
	            	obj_Joiners.setOrganizerID(rs.getInt("OrganizerID"));          	
	            	obj_Joiners.setFirstName(rs.getString("FirstName"));
	            	obj_Joiners.setLastName(rs.getString("LastName"));
	            
	            	//obj_Joiners.setExtensionName(rs.getString("ExtensionName"));
	               	obj_Joiners.setAge(rs.getInt("Age"));
	            	obj_Joiners.setAddress(rs.getString("Address"));
	               	obj_Joiners.setContact(rs.getString("CellNo"));
	          //  	obj_Joiners.setUsername(rs.getString("Username"));
	             	obj_Joiners.setEmail(rs.getString("Email"));
	            	obj_Joiners.setPassword(rs.getString("Password"));
	               	obj_Joiners.setAccountStatus(rs.getString("Accoutnstatus"));
	            	obj_Joiners.setIDtype(rs.getString("IDtype"));
	        
	          
	               	list_of_Organizers.add(obj_Joiners);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }finally{
	            if(connection!=null){
	                connection.close();
	            }
	        }
	        return list_of_Organizers;
	    }

}
