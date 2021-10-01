package com.benilde.lecture.model;


import java.sql.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean
public class Accounts {
	
	private int AccountID;
	private String firstname;
	private String schoolname;
	private String middlename;
	private String lastname;
	private String UserType;
	private int Age;
	private String Address;

	private String TelNo;
	private String CelNo;
	private String Email;
	private String Password;
	private String passwordResult;
	private String confirmPassword;
	private int bootcampID;
	private String EnrollmentStatus;

	private String AccountStatus;
	
	private Timestamp CreationDate;
	private Timestamp  ModifiedDate;

	private String CreationDatestring;
	private String  ModifiedDatestring;
	
	
	public Accounts(){
		
	}
	public Accounts(int bootcampID, int AccountID, String EnrollmentStatus){
		
		this.bootcampID = bootcampID;
		this.AccountID = AccountID;
		this.EnrollmentStatus = EnrollmentStatus;
		
	}
	public Accounts(int AccountID, String schoolname,
			String UserType, String Address, String TelNo, String CelNo
			,String Email, String Password, String AccountStatus,Timestamp 
			CreationDate,Timestamp ModifiedDate){
		
		this.AccountID = AccountID;
		 this.schoolname = schoolname;
	
		 this.ModifiedDate =ModifiedDate;
		 this.CreationDate =CreationDate;
		this.UserType = UserType;
		
		 this.Address = Address;
		this.TelNo =TelNo;
		this.CelNo = CelNo;
		 this.Email = Email;
		 this.Password = Password;
		this.AccountStatus =AccountStatus;
	}
	
	public Accounts(int AccountID, String firstname,String middlename, String lastname, 
			int Age, String Address, String TelNo, String CelNo
			,String Email,  String EnrollmentStatus){
		
		this.AccountID = AccountID;
		 this.firstname = firstname;
		 this.middlename = middlename;
		 this.lastname = lastname;

	
		 this.Age = Age;
		 this.Address = Address;
		this.TelNo =TelNo;
		this.CelNo = CelNo;
		 this.Email = Email;
	
		this.EnrollmentStatus =EnrollmentStatus;
	}
	
	

	
	public Accounts(int AccountID, String firstname,String middlename, String lastname, 
			String UserType,int Age, String Address, String TelNo, String CelNo
			,String Email, String Password, String AccountStatus,Timestamp CreationDate,Timestamp ModifiedDate){
		
		this.AccountID = AccountID;
		 this.firstname = firstname;
		 this.middlename = middlename;
		 this.lastname = lastname;
		 this.ModifiedDate =ModifiedDate;
		 this.CreationDate =CreationDate;
		this.UserType = UserType;
		 this.Age = Age;
		 this.Address = Address;
		this.TelNo =TelNo;
		this.CelNo = CelNo;
		 this.Email = Email;
		 this.Password = Password;
		this.AccountStatus =AccountStatus;
	}

	
	public String getPasswordResult() {
		return passwordResult;
	}
	public void setPasswordResult(String passwordResult) {
		this.passwordResult = passwordResult;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMiddlename() {
		return middlename;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
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

	public String getTelNo() {
		return TelNo;
	}

	public void setTelNo(String telNo) {
		TelNo = telNo;
	}

	public String getCelNo() {
		return CelNo;
	}

	public void setCelNo(String celNo) {
		CelNo = celNo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAccountStatus() {
		return AccountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		AccountStatus = accountStatus;
	}


	public int getId() {
		return AccountID;
	}

	public void setId(int AccountID) {
		this.AccountID = AccountID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public int getBootcampID() {
		return bootcampID;
	}


	public void setBootcampID(int bootcampID) {
		this.bootcampID = bootcampID;
	}


	public String getEnrollmentStatus() {
		return EnrollmentStatus;
	}


	public void setEnrollmentStatus(String enrollmentStatus) {
		EnrollmentStatus = enrollmentStatus;
	}

	public Timestamp getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(Timestamp creationDate) {
		CreationDate = creationDate;
	}

	public Timestamp getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public String getCreationDatestring() {
		return CreationDatestring;
	}
	public String getModifiedDatestring() {
		return ModifiedDatestring;
	}
	public void setCreationDatestring(String creationDatestring) {
		CreationDatestring = creationDatestring;
	}
	public void setModifiedDatestring(String modifiedDatestring) {
		ModifiedDatestring = modifiedDatestring;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	
	public String getpasswordResult() {
		
		if(!Password.isEmpty())
		{
			{
			if(Password.length() < 3)			
				passwordResult = "Poor";
			
			else if(Password.length() < 7)			
				passwordResult = "Good";
			
			else if(Password.length() < 11)
			
				passwordResult = "Superb";
					
			else
			
				passwordResult = "Excellent";
			}
		}
		else		
			passwordResult = "";
			
		return passwordResult;
	}

	public void setpasswordResult(String passwordResult) {
		this.passwordResult = passwordResult;
	}
	
	


}
