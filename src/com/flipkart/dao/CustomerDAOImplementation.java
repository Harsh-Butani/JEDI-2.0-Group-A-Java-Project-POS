/**
 *
 */

package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLOutput;

import com.flipkart.bean.BookingList;
import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.bean.User;

/**
 *
 */
public class CustomerDAOImplementation implements CustomerDAOInterface {
	DatabaseConnector dbc;

	public CustomerDAOImplementation() {
		dbc = new DatabaseConnector();
	}

	@Override
	public void queryAllGymDB() {
		try {
			String sql = "select GymID, GymName, GymAddress from gym";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			while(rs.next()){
				String gymID = rs.getString("gymID");
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.println("GymID: " + gymID + ", GymName: " + gymName + "gymAddress: " + gymAddress);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber) {
		try {
			String sql = "select UserID, slotNumber from bookingList where UserID = " + UserID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			if(rs.next()){
				return true;
			}
			return false;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber) {
		try {
			String sql = "select availableSeats from slot where gymID = " + gymID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			Integer currentSeats = rs.getInt("availableSeats");
			currentSeats--;
			sql = "update slot set availableSeats = " + currentSeats + " wherer gymID = " + gymID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void addBookingListDB(Integer userID, Integer gymID, Integer slotNumber) {
		try {
			String sql = "insert into bookingList values ( " + userID + " , " + gymID + " , " + slotNumber + ")";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber) {
		try {
			String sql = "select availableSeats from slot where gymID = " + gymID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			Integer currentSeats = rs.getInt("availableSeats");
			currentSeats++;
			sql = "update slot set availableSeats = " + currentSeats + " wherer gymID = " + gymID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBookingListDB(Integer userID, Integer slotNumber) {
		try {
			String sql = "delete from bookingList where userID = " + userID + " and slotNumber = " + slotNumber;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			dbc.stmt.executeUpdate(sql);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void queryBookingListDB(Integer userID) {
		try {
			String sql = "select * from bookingList where userID = " + userID;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			while(rs.next()){
				Integer ruserID = rs.getInt("userID");
				String gymID = rs.getString("gymID");
				String slotNumber = rs.getString("slotNumber");
				System.out.println("userID: " + ruserID + ", GymID: " + gymID + "slotNumber: " + slotNumber);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void queryGymDB(Integer gymID) {
		try {
			String sql = "select * from gym where gymID = " + gymID;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			if(rs.next()){
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.println("gymName: " + gymName + ", gymAddress: " + gymAddress);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void querySeatsSlotDB(Integer gymID) {
		try {
			String sql = "select slotNumber, availableSeats from slot where gymID = " + gymID + "and availableSeats > 0";
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			while(rs.next()){
				Integer slotNumber = rs.getInt("slotNumber");
				Integer availableSeats = rs.getInt("availableSeats");
				System.out.println("slotNumber: " + slotNumber + ", availableSeats: " + availableSeats);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID) {
		try {
			String sql = "select UserID, slotNumber from bookingList where UserID = " + UserID + " and slotNumber = " + slotNumber + " and gymID = " + gymID;
			dbc.stmt = dbc.conn.prepareStatement(sql);
			ResultSet rs = dbc.stmt.executeQuery(sql);
			if(rs.next()){
				return true;
			}
			return false;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
//	DatabaseConnector dbc;
//
//	public void init() {
//		dbc = new DatabaseConnector();
//		dbc.init();
//	}
//
//	@Override
//	public void insertUserDB(User user) {
//		// TODO Auto-generated method stub
//		try {
//
//			String sql = "insert into User values(?,?,?,?)";
//			dbc.stmt = dbc.conn.prepareStatement(sql);
//			dbc.stmt.setInt(1, user.getUserID());
//			dbc.stmt.setString(2, user.getEmailID());
//			dbc.stmt.setString(3, user.getPassword());
//			dbc.stmt.setString(4, user.getRole());
//			dbc.stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	public void updateUserDB(User user, String password) {
//		// TODO Auto-generated method stub
//		try {
//
//			String sql = "update User set password=(?) where email=(?) and password=(?) and role=(?)";
//			dbc.stmt = dbc.conn.prepareStatement(sql);
//			dbc.stmt.setString(1, password);
//			dbc.stmt.setString(2, user.getEmailID());
//			dbc.stmt.setString(3, user.getPassword());
//			dbc.stmt.setString(4, user.getRole());
//			dbc.stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	public User getUser(User user) {
//		// TODO Auto-generated method stub
//		try {
//			String sql = "SELECT * FROM User";
//			dbc.stmt = dbc.conn.prepareStatement(sql);
//		     ResultSet rs = dbc.stmt.executeQuery(sql);
//		     User currUser = null;
//		      //STEP 5: Extract data from result set
//		      while(rs.next()){
//		         //Retrieve by column name
//		         String email = rs.getString("email");
//		         String password = rs.getString("password");
//		         String role = rs.getString("role");
//		         if(email.equals(user.getEmailID()) && password.equals(user.getPassword()) && role.equals(user.getRole())){
//		        	 currUser = new User(false);
//			         currUser.setEmailID(email);
//			         currUser.setPassword(password);
//			         currUser.setRole(role);
//		         }
//		      }
//		      return currUser;
//		} catch (Exception e) {
//			System.out.println(e);
//			return null;
//		}
//	}
//
//	@Override
//	public void insertGymDB(GymDetails gym) {
//		// TODO Auto-generated method stub
//		try {
//
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Override
//	public void insertBookingListDB(BookingList list) {
//		// TODO Auto-generated method stub
//		try {
//
////			String sql = "insert into User values(?,?)";
////			dbc.stmt = dbc.conn.prepareStatement(sql);
////			dbc.stmt.setString(1, user.getEmailID());
////			dbc.stmt.setString(2, user.getPassword());
////			dbc.stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	@Override
//	public void insertSlotCatalogDB(SlotCatalogDetails slot) {
//		// TODO Auto-generated method stub
//		try {
//
////			String sql = "insert into User values(?,?)";
////			dbc.stmt = dbc.conn.prepareStatement(sql);
////			dbc.stmt.setString(1, user.getEmailID());
////			dbc.stmt.setString(2, user.getPassword());
////			dbc.stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}



}