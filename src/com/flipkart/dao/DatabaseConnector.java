/**
 *
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class DatabaseConnector {

		// Step 1
		// JDBC driver name and database URL
		   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		   static final String DB_URL = "jdbc:mysql://localhost/FlipFit";

		   //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "Bhagtu@744";
		   Connection conn = null;
		   PreparedStatement stmt = null;

		   public DatabaseConnector() {
			   try{
			   Class.forName("com.mysql.cj.jdbc.Driver");
			      System.out.println("Connecting to database...");
			      conn = DriverManager.getConnection(DB_URL,USER,PASS);
			      System.out.println("Connection established successfully");
			   }
			   catch(SQLException se){
				      //Handle errors for JDBC
				      se.printStackTrace();
				   }catch(Exception e){
				      //Handle errors for Class.forName
				      e.printStackTrace();
				   }
		   }




}
