/**
 * 
 */
package com.flipkart.dao;

import java.sql.ResultSet;

import com.flipkart.bean.User;

/**
 * 
 */
public class UserDAOImplementation implements UserDAOInterface{
	DatabaseConnector dbc;
	public UserDAOImplementation() {
		dbc = new DatabaseConnector();
	}

	@Override
	public void insertUserDB(User user) {
		try {

			String sql = "insert into User (email,password,role) values(?,?,?)";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.setString(1, user.getEmailID());
			dbc.stmt.setString(2, user.getPassword());
			dbc.stmt.setString(3, user.getRole());
			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public void updateUserDB(User user, String password) {
		// TODO Auto-generated method stub
		try {

			String sql = "update User set password=(?) where email=(?) and password=(?) and role=(?)";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.setString(1, password);
			dbc.stmt.setString(2, user.getEmailID());
			dbc.stmt.setString(3, user.getPassword());
			dbc.stmt.setString(4, user.getRole());
			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public User getUserDB(User user) {
		// TODO Auto-generated method stub
		try {
			String sql = "SELECT * FROM User";
			dbc.stmt = dbc.conn.prepareStatement(sql);
		     ResultSet rs = dbc.stmt.executeQuery(sql);
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
