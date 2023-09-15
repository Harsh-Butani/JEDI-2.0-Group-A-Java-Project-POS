/**
 * 
 */

package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flipkart.bean.BookingList;
import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.bean.User;

/**
 * 
 */
public class CustomerDAOImplementation implements CustomerDAOInterface {
	DatabaseConnector dbc;

	public void init() {
		dbc = new DatabaseConnector();
		dbc.init();
	}

	@Override
	public void insertUserDB(User user) {
		// TODO Auto-generated method stub
		try {

			String sql = "insert into User values(?,?,?,?)";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.setInt(1, user.getUserID());
			dbc.stmt.setString(2, user.getEmailID());
			dbc.stmt.setString(3, user.getPassword());
			dbc.stmt.setString(4, user.getRole());
			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateUserDB(User user, String password) {
		// TODO Auto-generated method stub
		try {

			String sql = "update User set password=? where email=? and password=? and role=?";
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
	
	public User getUser(User user) {
		// TODO Auto-generated method stub
		try {

			String sql = "SELECT email, password, role FROM user where email=? and password=? and role=?";
			dbc.stmt.setString(1, user.getEmailID());
			dbc.stmt.setString(2, user.getPassword());
			dbc.stmt.setString(3, user.getRole());
		     ResultSet rs = dbc.stmt.executeQuery(sql);
		     User currUser = null;
		      //STEP 5: Extract data from result set
		      if(rs.next()){
		         //Retrieve by column name
		         String email = rs.getString("email");
		         String password = rs.getString("password");
		         String role = rs.getString("role");

		         //Display values
		         System.out.println("email: " + email);
		         System.out.println("password: " + password);
		         System.out.println("role: " + role);
		         
		         currUser = new User(false);
		         currUser.setEmailID(email);
		         currUser.setPassword(password);
		         currUser.setRole(role);
		      }
		      return currUser;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void insertGymDB(GymDetails gym) {
		// TODO Auto-generated method stub
		try {

			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insertBookingListDB(BookingList list) {
		// TODO Auto-generated method stub
		try {

//			String sql = "insert into User values(?,?)";
//			dbc.stmt = dbc.conn.prepareStatement(sql);
//			dbc.stmt.setString(1, user.getEmailID());
//			dbc.stmt.setString(2, user.getPassword());
//			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insertSlotCatalogDB(SlotCatalogDetails slot) {
		// TODO Auto-generated method stub
		try {

//			String sql = "insert into User values(?,?)";
//			dbc.stmt = dbc.conn.prepareStatement(sql);
//			dbc.stmt.setString(1, user.getEmailID());
//			dbc.stmt.setString(2, user.getPassword());
//			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
