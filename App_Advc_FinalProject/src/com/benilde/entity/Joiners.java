package com.benilde.entity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.benilde.service.DB_connection;

@ManagedBean
public class Joiners {
	
	private int JoinerID;
	private String FirstName;
	private String LastName;
	private String MiddleName;
	private String ExtensionName;
	private int Age;
	private String Address;
	private String Contact;
	private String Username;
	private String Password;
	private String Usertype;
	private String Email;
	private String IDtype;
	public String getIDtype() {
		return IDtype;
	}


	private int IDnumber;
	
	
	
	public int getJoinerID() {
		return JoinerID;
	}

	public void setJoinerID(int joinerID) {
		JoinerID = joinerID;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getContact() {
		return Contact;
	}


	public void setContact(String contact) {
		Contact = contact;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getUsertype() {
		return Usertype;
	}


	public void setUsertype(String usertype) {
		Usertype = usertype;
	}


	public String get	() {
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

	
	  public ArrayList<Joiners> getGet_all_Joiners() throws Exception{
	        ArrayList<Joiners> list_of_Joiners=new ArrayList<Joiners>();
	             Connection connection=null;
	        try {
	            DB_connection obj_DB_connection=new DB_connection();
	            connection=obj_DB_connection.get_connection();
	            Statement st=connection.createStatement();
	            ResultSet rs=st.executeQuery("select * from joiners");
	            while(rs.next()){
	            	Joiners obj_Joiners =new Joiners();
	            	obj_Joiners.setJoinerID(rs.getInt("JoinerID"));
	            	obj_Joiners.setFirstName(rs.getString("FirstName"));
	            	obj_Joiners.setLastName(rs.getString("LastName"));
	               	obj_Joiners.setMiddleName(rs.getString("MiddleName"));
	            	obj_Joiners.setExtensionName(rs.getString("ExtensionName"));
	               	obj_Joiners.setAge(rs.getInt("Age"));
	            	obj_Joiners.setAddress(rs.getString("Address"));
	               	obj_Joiners.setContact(rs.getString("ContactNum"));
	            	obj_Joiners.setUsername(rs.getString("Username"));
	             	obj_Joiners.setEmail(rs.getString("Email"));
	            	obj_Joiners.setPassword(rs.getString("Password"));
	               	obj_Joiners.setUsertype(rs.getString("Usertype"));
	            	obj_Joiners.setIDtype(rs.getString("IDtype"));
	               	obj_Joiners.setIDnumber(rs.getInt("IDnumber"));
	            
	            	list_of_Joiners.add(obj_Joiners);
	            }
	        } catch (Exception e) {
	            System.out.println(e);
	        }finally{
	            if(connection!=null){
	                connection.close();
	            }
	        }
	        return list_of_Joiners;
	    }

}
