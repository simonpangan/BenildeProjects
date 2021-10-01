
package com.benilde.lecture.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import com.benilde.lecture.schoolDBUtil;
import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;

@ManagedBean(name = "schoolcontroller", eager = true)
@SessionScoped

public class schoolcontroller {


	  
	private schoolDBUtil schoolutil;
	
	
	private List<bootcamp> bootcamp;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	private List<Accounts> bootcampjoiners;
	private int id;
	private int bootcampid;
	int[] bootcampinfo;
	
	
	
	
	public schoolcontroller() throws Exception {

		schoolutil = schoolDBUtil.getInstance();
		bootcamp = new ArrayList<>();
		bootcampjoiners = new ArrayList<>();
		id = 0;
		
		bootcampinfo = new int[3];
	}
	
	public List<Accounts> getBootcampjoiners() throws Exception{
		
		return bootcampjoiners;
	//	return projDBUtil.getBootcampjoiners(1);
	}
	
	
	public List<bootcamp> getBootcamp() {
		return bootcamp;
	}
	public int[] getBootcampinfo() {
		return bootcampinfo;
	}

	public int getId() {
		return id;
	}
	
	
	public String statuspdate(int id) {
		
		logger.info("account: " + id);
		
		try {
			
			// update student in the database
			schoolutil.updatestatus(id, bootcampid);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating student: " + id, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		
		
		
		return "joinerslist.xhtml";		
	}
	
	public String bootcampupdate(bootcamp thebootcamp) {
		
		logger.info("account: " + thebootcamp.getBootcampID());
		
		try {
			
			// update student in the database
			schoolutil.updatebootcamp(thebootcamp);
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating student: " + thebootcamp, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		
		
		
		return "schoolindex.xhtml";		
	}
	
	

	public void loadBootcampslist(int id){
		
		logger.info("load bootcamplist " + id);
		bootcamp.clear();
		
		
		try
		{
             // get all students from database
			bootcamp = schoolutil.getBootcamps(id);
				
            
		}
		catch(Exception ex)
		{
			// add error message for JSF page
			addErrorMessage(ex);
		}
	}

	public String loadBootcamp(int bootcampid) {
		
		
		logger.info("loading account: " + bootcampid);
	
		
		try {
			// get student from database
			bootcamp thebootcamp = schoolutil.getBootcampsinfo(bootcampid);
			
			
			ExternalContext externalContext = 
						FacesContext.getCurrentInstance().getExternalContext();		
			
			
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("bootcamp", thebootcamp);	
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading bootcamp id:" + bootcampid, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
		
		}
		
					
		return "bootcampupdate.xhtml";
	}

	public String navigate(){
		
		logger.info("NAVIGATING");
		return "schoolindex.xhtml?faces-redirect=true";
	}

	
	public String addbootcamp(bootcamp theboot) throws Exception{
	
	
	
		try{
			
			
			schoolutil.addBootcamp(theboot);
			
		}catch(Exception exc){
			logger.log(Level.SEVERE, "Error adding account", exc);
			
			addErrorMessage(exc);
			
			
			
			return null;
			
		}
		
		return "schoolindex.xhtml?faces-redirect=true";
	}
	
	public String deleteBootcamp(int id) {

		logger.info("Deleting account id: " + id);
		
		try {

			// delete the student from the database
			schoolutil.deletebootcamp(id);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting bootcamp id: " + id, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "schoolindex?faces-redirect=true";	
	}
	
	public void  deleteajoiner(int id) {

		logger.info("Deleting account id: " + id);
		
		try {

			// delete the student from the database
			schoolutil.deleteajoiner(id,bootcampid);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting bootcamp id: " + id, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			
		}
		
		
	}
	
	public String loadjoiners(int id) {
			
		//	bootcampjoiners.clear();
	
		
		this.id = id;
		
		bootcampid = id;
		
			try {
			
			
				
				bootcampjoiners = schoolutil.getUsers(id);
				bootcampinfo = schoolutil.getbootcampjoinersinfo(id);
			
			
		
				
			} catch (Exception exc) {
				// send this to server logs
				logger.log(Level.SEVERE, "Error loading account id:" + 8, exc);
				
				// add error message for JSF page
				addErrorMessage(exc);
				
			
			}
			
			
			return "joinerslist.xhtml?faces-redirect=true";
			
		}

	
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public int getBootcampid() {
		return bootcampid;
	}

	public void setBootcampid(int bootcampid) {
		this.bootcampid = bootcampid;
	}
	
	
}
