package com.client.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {


	static Connection conn=null;
	public static Connection getConnection()
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded...");
			//conn=DriverManager.getConnection("jdbc:mysql://5.189.132.169:3306/seed_block","ft","ft123");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/student_management","root","");
			
			System.out.println("Connection Established...");
			return conn;
			
			
		    } 
		catch (Exception e) 
		    {
				e.printStackTrace();
			}
		
		return null;
	}
	
	public static void CloseConnection()
	  {
	    try
	    {
	       conn.close();
	       conn = null;
	    }
	    catch (SQLException e)
	    {
	       e.printStackTrace();
	    } 
	  }
}
