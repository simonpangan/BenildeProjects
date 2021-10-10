package com.benilde.service;

import java.sql.Connection;
import java.sql.DriverManager;




public class DB_connection {
	
	public static void main(String[] args){
		DB_connection obj_DB_connection=new DB_connection();
		
		System.out.println(obj_DB_connection.get_connection());
	}
	public Connection get_connection(){
		
		Connection connection = null;
		
		try{ 
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/javafinal","root","");
		}catch(Exception e){
			System.out.println(e);
		}
		
		return connection;
		
	}

}
