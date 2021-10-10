package com.benilde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;

import com.benilde.entity.Category;
import com.benilde.service.DB_connection;


@ManagedBean
public class accountregister {
	
	public String register(){
		
		Category register= new Category();
		register.add_Category();
		return "index.xhtml";
		
	
		
	}


}
