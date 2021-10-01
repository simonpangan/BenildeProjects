	
package com.benilde.lecture.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.benilde.lecture.ProjDBUtil;

import com.benilde.lecture.adminDBUtil;
import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;

@ManagedBean
@SessionScoped
public class admincontroller {

	
	private adminDBUtil projDBUtil;
	static String usertype;
	private List<Accounts> accounts;
	private int data[];
	
	private Logger logger = Logger.getLogger(getClass().getName());
	private String previousPage = null;
	



	public admincontroller() throws Exception {
		accounts = new ArrayList<>();
		projDBUtil = adminDBUtil.getInstance();
		usertype = "";
		data = new int[8];
	}	
	
	/*
	public  void isPostback() {
		   String msg = "";
		    UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
		    String id = viewRoot.getViewId();
		    if (previousPage != null && (previousPage.equals(id))) {
		       // It's a reload event
		    }else{
		    	getdatas();
		    }
		    previousPage = id;
		} 
	*/
	public void getdatas(){
		logger.info("Loading datas");
		
	
		data = new int[8];
		try
		{
			data = projDBUtil.getcountcategorie();
		}
		
		catch(Exception ex)
		{
			// add error message for JSF page
			addErrorMessage(ex);
		}
	}
	

	public int[] getData() {
		return data;
	}
	
	
	public void school(){
		setUsertype("School");
	}
	public void admin(){
		setUsertype("Admin");
	}
	
	
	
	public String getUsertype() {
		return usertype;
	}


	public static  void setUsertype(String usertype) {
		admincontroller.usertype = usertype;
	}


	
	public List<Accounts> getAccounts() {
		return accounts;
	}


	public void loadAccounts()
	{
		logger.info("Loading accounts");
		accounts.clear();
		
		try
		{
             // get all students from database
			accounts = projDBUtil.getUsers();
            
		}
		catch(Exception ex)
		{
			// add error message for JSF page
			addErrorMessage(ex);
		}
	}
	


	public String deleteAccount(int id) {

		logger.info("Deleting account id: " + id);
		
		try {

			// delete the student from the database
			projDBUtil.deleteaccount(id);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting student id: " + id, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "student-db-main?faces-redirect=true";	
	}
	
	
	public String updateacc(Accounts theaccount) {
		
	
		logger.info("updating student: " + theaccount.getSchoolname());
		
		
		try {
			
			// update student in the database
			projDBUtil.updateaccount(theaccount);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating student: " + theaccount, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		
		return "index.xhtml?faces-redirect=true";		
	}
	
	
	
	public String loadAccount(int accountID) {
			
	
			logger.info("loading account: " + accountID);
			
			try {
				// get student from database
				Accounts theaccount = projDBUtil.getAccount(accountID);
				
				
				

				ExternalContext externalContext = 
							FacesContext.getCurrentInstance().getExternalContext();		
				
				
				Map<String, Object> requestMap = externalContext.getRequestMap();
				requestMap.put("accounts", theaccount);	
				
			
			
			} catch (Exception exc) {
				// send this to server logs
				logger.log(Level.SEVERE, "Error loading account id:" + accountID, exc);
				
				// add error message for JSF page
				addErrorMessage(exc);
				
				
	
			}
			return "update.xhtml";
			
		}

	
	
	
		public String addAccount(Accounts theaccount){
			logger.info("Adding account: " + theaccount);
			
			
			theaccount.setUserType(admincontroller.usertype);
			try{
				
				
				projDBUtil.addAccount(theaccount);
				
			}catch(Exception exc){
				logger.log(Level.SEVERE, "Error adding account", exc);
				
				addErrorMessage(exc);
				
				
				
				return null;
				
			}
			
			return "index.xhtml?faces-redirect=true";
		}


	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	
}
