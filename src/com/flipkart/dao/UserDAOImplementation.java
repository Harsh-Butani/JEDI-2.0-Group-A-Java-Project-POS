/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flipkart.bean.User;
import com.flipkart.constants.SQLConstants;
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
			stmt = conn.prepareStatement(SQLConstants.REGISTER_USER_QUERY);
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

			stmt = conn.prepareStatement(SQLConstants.UPDATE_USER_PASSWORD_QUERY);
			stmt.setString(1, password);
			stmt.setString(2, user.getEmailID());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getRole());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
//	@Override
//	public User getUserDB(User user) {
//		// TODO Auto-generated method stub
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		try {
//			conn = DatabaseConnector.getConnection();
//
//
//			stmt = conn.prepareStatement(SQLConstants.QUERY_USER_DB_FOR_EMAIL_ROLE);
//
//			stmt.setString(1, user.getEmailID());
//
//			stmt.setString(2, user.getRole());
//
//		    ResultSet rs = stmt.executeQuery();
//
//		    User currUser = null;
//		    while(rs.next()){
//		        String email = rs.getString("email");
//		        String password = rs.getString("password");
//		        String role = rs.getString("role");
//		        if(email.equals(user.getEmailID()) && role.equals(user.getRole())){
//		        	currUser = new User();
//			        currUser.setEmailID(email);
//			        currUser.setPassword(password);
//			        currUser.setRole(role);
//			        return currUser;
//		        }
//		    }
//		    return null;
//		} catch (Exception e) {
//			System.out.println(e);
//			return null;
//		}
//	}

	@Override
	public Boolean queryUserDB(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();


			stmt = conn.prepareStatement(SQLConstants.QUERY_USER_DB_FOR_EMAIL_ROLE);
			stmt.setString(1,user.getEmailID());
			stmt.setString(2, user.getRole());
		    ResultSet rs = stmt.executeQuery();
		      if(rs.next()){
		         return true;
		      }
		      return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean queryDetailsUserDB(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();


			stmt = conn.prepareStatement(SQLConstants.QUERY_USER_DB_FOR_EMAIL_ROLE_PASSWORD);
			stmt.setString(1, user.getEmailID());
			stmt.setString(2, user.getRole());
			stmt.setString(3, user.getPassword());
		    ResultSet rs = stmt.executeQuery();
		      if(rs.next()){
		         return true;
		      }
		      return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
}
