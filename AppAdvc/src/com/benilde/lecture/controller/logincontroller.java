
package com.benilde.lecture.controller;


import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.benilde.lecture.Helper;
import com.benilde.lecture.model.bootcamp;


@ManagedBean(name = "logincontroller", eager = true)
@SessionScoped
public class logincontroller {

		private   String email;
		private String password;
		private String check;
		private String message;
		private boolean login;
		private String usertype;
		private int accountID;
		
		public logincontroller(){
			email  = "";
			password ="";
			check = "";
			message ="";
			usertype ="";
			accountID = 0;
			login = false;
		}
		
		public void isLogin(){
			
			if(!login){
				doRedirect("faces/login.xhtml");			
			}	
		}
		
		
		
		public void verify() throws Exception{
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    String code = ec.getRequestParameterMap().get("formId:codeverification");
		    
		 
		    Boolean check = Helper.verification(this.email, code);
		    		
		    		if(!check){
		    		    FacesContext.getCurrentInstance().addMessage(null, 
		    		            new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid code", null));
		    		}else{
		    			Helper.changestatus(this.email);
		    			doRedirect("faces/joiner/allbootcamps.xhtml");
		    		}

		    
		}
		
	
		public  String redirect(int temp) throws Exception{
			
		
			
			joinercontroller temp1 = new joinercontroller();
			
		temp1.redirect(temp, email);
		  
			return "allbootcamps.xhtml";
			
			
		}
		
		
		public void isJoiner() throws Exception{
					
					if(!this.usertype.equals("Joiner")){
						
					
						doRedirect("faces/login.xhtml");			
					}	
				}
				
		
		
		public void isAdmin(){
			
			if(!this.usertype.equals("Admin")){
				doRedirect("faces/login.xhtml");			
			}	
		}
		
		
		public void isSchool(){
			
			if(!this.usertype.equals("School")){
				doRedirect("faces/login.xhtml");			
			}	
		}
		

		public void isVerified() throws Exception{
			
			if(this.email != null){
				if(!Helper.checkforstatis(this.email).equals("Active")){
					doRedirect("faces/joiner/joinerverification.xhtml");			
				}	
			}
		
		}
	
		
		private void doRedirect(String url){
			try{
				/*
				FacesContext fc = FacesContext.getCurrentInstance();
				fc.getExternalContext().redirect(url);
				*/
				ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
				ec.redirect(ec.getRequestContextPath() + "/" + url);
			}catch(Exception e){
				
			}
		}
		
		public String login(){
			
	
			boolean realacc; 	
			try {
				realacc = Helper.checkforacc(this.email, Helper.encryptThisString(this.password));
			

				Helper.usertype(this.email);
				if(realacc){
					
				
				
					
					this.login = realacc;
					this.check = Helper.usertype(this.email);
					
					if(this.check.equals("Joiner")){
						this.usertype = "Joiner";
						
						if(Helper.checkforstatis(this.email).equals("Active")){
							return "joiner/allbootcamps.xhtml?faces-redirect=true";	
						}
						return "joiner/joinerverification.xhtml?faces-redirect=true";	
						
					}else if(this.check.equals("School")){
						this.usertype = "School";
						return "school/schoolindex.xhtml?faces-redirect=true";	
					}else if(this.check.equals("Admin")){
						this.usertype = "Admin";
						return "admin/index.xhtml?faces-redirect=true";	
					};
					this.message  ="Successfulll ";
				
				}	
				
			
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						

			this.message  ="Invalid credentials!!";
			return "login?faces-redirect=true";	
			
		}
		
		public void  logout(){
		
			this.login = false;
			doRedirect("faces/login.xhtml");		
			
		}
		
	
		
		public   String getEmail() {
			return email;
		}
		public String getPassword() {
			return password;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getCheck() {
			return check;
		}
		public void setCheck(String check) {
			this.check = check;
		}
		public String getMessage() {
			return message;
		}
		
		public void setMessage(String message) {
			this.message = message;
		}

		public String getUsertype() {
			return usertype;
		}

		public void setUsertype(String usertype) {
			this.usertype = usertype;
		}

		public int getAccountID() throws Exception {
	
			return Helper.id(this.email);
		}

		public void setLogin(boolean login) {
			this.login = login;
		}

		public void setAccountID(int accountID) {
			this.accountID = accountID;
		}
		
	
}
