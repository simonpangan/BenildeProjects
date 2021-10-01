
package com.benilde.lecture.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.benilde.lecture.Helper;
import com.benilde.lecture.ProjDBUtil;
import com.benilde.lecture.adminDBUtil;
import com.benilde.lecture.joinerDBUtil;
import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;

@ManagedBean
@SessionScoped
public class joinercontroller {

	
	private joinerDBUtil projDBUtil;
	private List<bootcamp> allbootcamp;
	private List<bootcamp> mybootcamp;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	
	public joinercontroller() throws Exception {
		allbootcamp= new ArrayList<>();
		mybootcamp= new ArrayList<>();
		projDBUtil = joinerDBUtil.getInstance();
	}
	
	
	public List<bootcamp> getAllbootcamp() {
		return allbootcamp;
	}
	
	public  void redirect(int temp, String email) throws Exception{
		
	
	    projDBUtil.requestjoin(temp, Helper.id(email));
	  
		
		
	}
	
	
	public  void  mybootcamp(int temp) throws Exception{
		
		
		mybootcamp = projDBUtil.myboot(temp);
	  
	
	}
	
	
	public String addAccountJoiner(Accounts theaccount){
		logger.info("Adding account: " + theaccount);
		
		
		try{
			
			
			projDBUtil.addAccountJoiner(theaccount);
			
			return "joinerverification.xhtml?faces-redirect=true";
		}catch(Exception exc){
			logger.log(Level.SEVERE, "Error adding account", exc);
			
			addErrorMessage(exc);
			
			
			
			return null;
			
		}
		
	
	}
	

	public String loadmyBootcamp(int bootcampid) {
			
	
			logger.info("loading account: " + bootcampid);
			
			try {
			
				
				
				bootcamp bootcamp = projDBUtil.getBootcampDetail(bootcampid);
				
				
				ExternalContext externalContext = 
							FacesContext.getCurrentInstance().getExternalContext();		
				
				
				Map<String, Object> requestMap = externalContext.getRequestMap();
				requestMap.put("bootcamp", bootcamp);	
				
				return "joinermybootcampdetails.xhtml";
					
				
			} catch (Exception exc) {
				// send this to server logs
				logger.log(Level.SEVERE, "Error loading bootcampid id:" + bootcampid, exc);
				
				// add error message for JSF page
				addErrorMessage(exc);
				
				return "adminregister.xhtml";
			}
			
			
			
						
		}

	public String loadBootcamp(int bootcampid) {
			
	
			logger.info("loading account: " + bootcampid);
			
			try {
			
				
				
				bootcamp bootcamp = projDBUtil.getBootcampDetail(bootcampid);
				
				
				ExternalContext externalContext = 
							FacesContext.getCurrentInstance().getExternalContext();		
				
				
				Map<String, Object> requestMap = externalContext.getRequestMap();
				requestMap.put("bootcamp", bootcamp);	
				
				return "bootcampdetails.xhtml";
					
				
			} catch (Exception exc) {
				// send this to server logs
				logger.log(Level.SEVERE, "Error loading bootcampid id:" + bootcampid, exc);
				
				// add error message for JSF page
				addErrorMessage(exc);
				
				return "adminregister.xhtml";
			}
			
			
			
						
		}

	public void loadBootcampslistjoiner(int id ){
		
		logger.info("load bootcamplist");
		allbootcamp.clear();
		
		try
		{
             // get all students from database
			allbootcamp = projDBUtil.getAllbootcamp(id);
            
		}
		catch(Exception ex)
		{
			// add error message for JSF page
			addErrorMessage(ex);
		}
	}

	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}


	public List<bootcamp> getMybootcamp() {
		return mybootcamp;
	}
	
	
}
