package com.benilde.controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.benilde.entity.EventListpercategory;

@ManagedBean
public class joinerscontroller {
	
	
	public ArrayList<EventListpercategory> getFullstackList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("fullstack");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<EventListpercategory> getMobiledevelopmentList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("mobiledevelopment");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<EventListpercategory> getCybersecurityList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("cybersecurity");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<EventListpercategory> getDigitalmarketingList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("digitalmarketing");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public ArrayList<EventListpercategory> getProductmanagementList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("productmanagement");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public ArrayList<EventListpercategory> getUxdesignList(){
		
		
		EventListpercategory fullstack = new EventListpercategory();
		
		try {
			return fullstack.Get_all_category("uxdesign");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
