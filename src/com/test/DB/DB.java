package com.test.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	public static Connection getDb()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//return the object of database
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb","root","");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
