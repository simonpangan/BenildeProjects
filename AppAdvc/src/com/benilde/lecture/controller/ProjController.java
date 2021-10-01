
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

import com.benilde.lecture.ProjDBUtil;
import com.benilde.lecture.adminDBUtil;
import com.benilde.lecture.model.Accounts;
import com.benilde.lecture.model.bootcamp;

@ManagedBean
@SessionScoped
public class ProjController {

	private List<Accounts> accounts;

	private List<Accounts> bootcampjoiners;
	
	private int[] accountsinfo;
	private ProjDBUtil projDBUtil;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	
	public ProjController() throws Exception {
	
		
		
	
		bootcampjoiners = new ArrayList<>();
		projDBUtil = ProjDBUtil.getInstance();
	}
	

	
	public List<Accounts> getAccounts() {
		return accounts;
	}
	public int[] getAccountsinfo() throws Exception {
		
		//return projDBUtil.infoList();
		return accountsinfo;
	}

	public List<Accounts> getBootcampjoiners() throws Exception{
	
		return bootcampjoiners;
	//	return projDBUtil.getBootcampjoiners(1);
	}
	
	
	public void loadaccountsinfo(){
		
		logger.info("load accountsinfo");
		accountsinfo = null;
		
		try
		{
             // get all students from database
			accountsinfo = projDBUtil.infoList();
            
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
	
	
}
