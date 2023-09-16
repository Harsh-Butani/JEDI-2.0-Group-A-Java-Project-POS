/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flipkart.bean.User;
import com.flipkart.utils.DatabaseConnector;

/**
 * 
 */
public class UserDAOImplementation implements UserDAOInterface{


	@Override
	public void insertUserDB(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			String sql = "insert into User (email,password,role) values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getEmailID());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public void updateUserDB(User user, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			String sql = "update User set password=(?) where email=(?) and password=(?) and role=(?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, password);
			stmt.setString(2, user.getEmailID());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public User getUserDB(User user) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			String sql = "SELECT * FROM User";
			stmt = conn.prepareStatement(sql);
		     ResultSet rs = stmt.executeQuery(sql);
		     User currUser = null;
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String email = rs.getString("email");
		         String password = rs.getString("password");
		         String role = rs.getString("role");
		         if(email.equals(user.getEmailID()) && password.equals(user.getPassword()) && role.equals(user.getRole())){
		        	 currUser = new User();
			         currUser.setEmailID(email);
			         currUser.setPassword(password);
			         currUser.setRole(role);
		         }
		      }
		      return currUser;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
