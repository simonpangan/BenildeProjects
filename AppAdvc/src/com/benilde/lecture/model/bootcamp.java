package com.benilde.lecture.model;



import java.util.Date;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class bootcamp {
	
	
	private int bootcampID;
	private int AccountID;
	private String BootcampName;
	private String BootcampDetails;
	private String Status;
	private String ClassDays;
	private String Venue;
	private String Categorie;
	private Date CreationDate;
	private Date ModifiedDate;
	private int slots;
	private int slotsleft;

	
	
	public bootcamp(){
		
	}

	public bootcamp(int bootcampID,int AccountID, String BootcampName,String BootcampDetails,
			String Status,
			int slots,int slotsleft,
			String ClassDays, 
			String Venue,String Categorie
			,Date CreationDate, Date ModifiedDate){
	
		
		this.slotsleft = slotsleft;
		this.bootcampID = bootcampID;
		this.AccountID = AccountID;
		 this.BootcampName = BootcampName;		 
		 this.BootcampDetails = BootcampDetails;	
		 this.slots = slots;
		 this.Status = Status;
		 this.ClassDays = ClassDays;
		 this.Venue = Venue; 
		 this.Categorie = Categorie;
		 this.CreationDate = CreationDate;
		 this.ModifiedDate = ModifiedDate;
		
	}



	public int getBootcampID() {
		return bootcampID;
	}



	public void setBootcampID(int bootcampID) {
		this.bootcampID = bootcampID;
	}



	public int getAccountID() {
		return AccountID;
	}



	public void setAccountID(int accountID) {
		AccountID = accountID;
	}



	public String getBootcampName() {
		return BootcampName;
	}



	public void setBootcampName(String bootcampName) {
		BootcampName = bootcampName;
	}



	public String getBootcampDetails() {
		return BootcampDetails;
	}



	public void setBootcampDetails(String bootcampDetails) {
		BootcampDetails = bootcampDetails;
	}



	public String getClassDays() {
		return ClassDays;
	}



	public void setClassDays(String classDays) {
		ClassDays = classDays;
	}



	public String getVenue() {
		return Venue;
	}



	public void setVenue(String venue) {
		Venue = venue;
	}



	public String getCategorie() {
		return Categorie;
	}



	public void setCategorie(String categorie) {
		Categorie = categorie;
	}







	public Date getCreationDate() {
		return CreationDate;
	}



	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}



	public Date getModifiedDate() {
		return ModifiedDate;
	}



	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}



	public String getStatus() {
		return Status;
	}



	public void setStatus(String status) {
		Status = status;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public int getSlotsleft() {
		return slotsleft;
	}

	public void setSlotsleft(int slotsleft) {
		this.slotsleft = slotsleft;
	}




}
