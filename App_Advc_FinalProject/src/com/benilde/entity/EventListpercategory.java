package com.benilde.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import com.benilde.service.DB_connection;

@ManagedBean
public class EventListpercategory {
	
	public EventListpercategory(){
		
	}
	
	private int EventID;
	private int OrganizerID;
	private String EventName;
	private String EventCategory;
	private String Date;
	private String Place;
	private int RegFee;
	private String Descriptions;
	private int SlotsAvailable;
	private String PeopleJoinedNo;
	private String Status;
	
	public int getEventID() {
		return EventID;
	}
	public void setEventID(int eventID) {
		EventID = eventID;
	}
	public int getOrganizerID() {
		return OrganizerID;
	}
	public void setOrganizerID(int organizerID) {
		OrganizerID = organizerID;
	}
	public String getEventName() {
		return EventName;
	}
	public void setEventName(String eventName) {
		EventName = eventName;
	}
	public String getEventCategory() {
		return EventCategory;
	}
	public void setEventCategory(String eventCategory) {
		EventCategory = eventCategory;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public int getRegFee() {
		return RegFee;
	}
	public void setRegFee(int regFee) {
		RegFee = regFee;
	}
	public String getDescriptions() {
		return Descriptions;
	}
	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}
	public int getSlotsAvailable() {
		return SlotsAvailable;
	}
	public void setSlotsAvailable(int slotsAvailable) {
		SlotsAvailable = slotsAvailable;
	}
	public String getPeopleJoinedNo() {
		return PeopleJoinedNo;
	}
	public void setPeopleJoinedNo(String peopleJoinedNo) {
		PeopleJoinedNo = peopleJoinedNo;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	public void eventregister(){
	    try {
	        Connection connection=null;
	        DB_connection obj_DB_connection=new DB_connection();
	        connection=obj_DB_connection.get_connection();
	     
	        String query ="";
	        
	  
	       query = " insert into events (EventName,EventCategory,"
	       		+ "Date,Place,RegFee,Descriptions,SlotsAvailable,Status)"
	  		   + " values (?,?,?,?,?,?,?,?)";

	   
			
	   PreparedStatement preparedStmt = connection.prepareStatement(query);
	   
			      preparedStmt.setString(1, EventName);
			      preparedStmt.setString(2, EventCategory);
			      preparedStmt.setString(3, Date);
			      preparedStmt.setString(4, Place);
			      preparedStmt.setInt(5, RegFee);
			      preparedStmt.setString(6, Descriptions);
			      preparedStmt.setInt(7, SlotsAvailable);
			      preparedStmt.setString(8, Status);
			      
			   	      
			      preparedStmt.execute();
			      connection.close();
			      
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}
	
	
	
	
	public ArrayList<EventListpercategory> Get_all_category(String eventname) 
			
	throws Exception{
        ArrayList<EventListpercategory> list_of_categories=new ArrayList<EventListpercategory>();
             Connection connection=null;
        try {
            DB_connection obj_DB_connection=new DB_connection();
            connection=obj_DB_connection.get_connection();
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery
       
            		
           ("select * from events Where EventCategory = '"+eventname+"'");
            
          
            
            while(rs.next()){
            	EventListpercategory obj_Category=new EventListpercategory();
                obj_Category.setEventID(rs.getInt("EventID"));
                obj_Category.setOrganizerID(rs.getInt("OrganizerID"));
                obj_Category.setRegFee(rs.getInt("RegFee"));
                
                obj_Category.setEventName(rs.getString("EventName"));
                obj_Category.setEventCategory(rs.getString("EventCategory"));
                
            
                obj_Category.setDate(rs.getString("Date"));
               obj_Category.setPlace(rs.getString("Place"));
                obj_Category.setDescriptions(rs.getString("Descriptions"));
                obj_Category.setSlotsAvailable(rs.getInt("SlotsAvailable"));
                obj_Category.setPeopleJoinedNo(rs.getString("PeopleJoinedNo"));
                obj_Category.setStatus(rs.getString("Status"));
                
                
               
                list_of_categories.add(obj_Category);
            }
        } catch (Exception e) {
            System.out.println(e);
        }finally{
            if(connection!=null){
                connection.close();
            }
        }
        return list_of_categories;
    }
	
	

}
