/**
 *
 */

package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

/**
 *
 */
public class CustomerDAOImplementation implements CustomerDAOInterface {

	@Override
	public boolean queryAllGymDB() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_GYMS_QUERY);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				flag = true;
				String gymID = rs.getString("gymID");
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.println("GymID: " + gymID + ", GymName: " + gymName + ", GymAddress: " + gymAddress);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_CUSTOMER_BOOKING_LIST_DB_QUERY);
			stmt.setInt(1, UserID);
			stmt.setInt(2, slotNumber);
			ResultSet rs = stmt.executeQuery();
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
	public Integer queryCancelBookingDB(Integer UserID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_CUSTOMER_BOOKING_LIST_DB_QUERY);
			stmt.setInt(1, UserID);
			stmt.setInt(2, slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("gymID");
			}
			return -1;
		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	@Override
	public Integer queryUserDBForID(String email, String password, String role) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_USER_DB_FOR_USERID);
			stmt.setString(1,email);
			stmt.setString(2,password);
			stmt.setString(3,role);


			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("UserID");
			}
			return -1;
		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}

	}

	@Override
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();

			stmt = conn.prepareStatement(SQLConstants.VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_DECREASE);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Integer currentSeats = rs.getInt("availableSeats");
				currentSeats--;
				stmt = conn.prepareStatement(SQLConstants.DECREASE_AVAILABLE_SEATS_FROM_SLOT);
				stmt.setInt(1,currentSeats);
				stmt.setInt(2,gymID);
				stmt.setInt(3,slotNumber);
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("Inside catch of decreaseSeats()");
			System.out.println(e);
		}
	}

	@Override
	public void addBookingListDB(Integer userID, Integer gymID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.ADD_BOOKING_TO_CUSTOMER_BOOKINGLIST);
			stmt.setInt(1,userID);
			stmt.setInt(2,gymID);
			stmt.setInt(3,slotNumber);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_INCREASE);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Integer currentSeats = rs.getInt("availableSeats");
				currentSeats++;
				stmt = conn.prepareStatement(SQLConstants.INCREASE_AVAILABLE_SEATS_FROM_SLOT);
				stmt.setInt(1,currentSeats);
				stmt.setInt(2,gymID);
				stmt.setInt(3,slotNumber);
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBookingListDB(Integer userID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.DELETE_BOOKING_FROM_BOOKINGLIST);
			stmt.setInt(1,userID);
			stmt.setInt(2, slotNumber);
			stmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean queryBookingListDB(Integer userID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_BOOKINGS_OF_A_USER);
			stmt.setInt(1,userID);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				flag = true;
				Integer ruserID = rs.getInt("userID");
				String gymID = rs.getString("gymID");
				String slotNumber = rs.getString("slotNumber");
				System.out.println("userID: " + ruserID + ", GymID: " + gymID + ", slotNumber: " + slotNumber);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public void queryGymDB(Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_INFO_OF_A_PARTICULAR_GYM);
			stmt.setInt(1,gymID);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.println("gymName: " + gymName + ", gymAddress: " + gymAddress);
			}else{
				System.out.println("No approved/registered gym with following gymID");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean querySeatsSlotDB(Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_AVAILABLE_SLOTS_OF_A_PARTICULAR_GYM);
			stmt.setInt(1,gymID);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				flag = true;
				Integer slotNumber = rs.getInt("slotNumber");
				Integer availableSeats = rs.getInt("availableSeats");
				System.out.println("slotNumber: " + slotNumber + ", availableSeats: " + availableSeats);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_BOOKING_OF_A_USER_FOR_CANCELLATION);
			stmt.setInt(1,UserID);
			stmt.setInt(2,slotNumber);
			stmt.setInt(3,gymID);
			ResultSet rs = stmt.executeQuery();
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
	public Boolean slotFull(Integer gymID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.CHECK_SEATS_AVAILABLE_FOR_GIVEN_GYM_AND_SLOT);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
//	DatabaseConnector dbc;
//
//	public void init() {
//		dbc = new DatabaseConnector();
//		init();
//	}
//
//	@Override
//	public void insertUserDB(User user) {
//		// TODO Auto-generated method stub
//		try {
//
//			String sql = "insert into User values(?,?,?,?)";
//			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, user.getUserID());
//			stmt.setString(2, user.getEmailID());
//			stmt.setString(3, user.getPassword());
//			stmt.setString(4, user.getRole());
//			stmt.executeUpdate();
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
//			stmt = conn.prepareStatement(sql);
//			stmt.setString(1, password);
//			stmt.setString(2, user.getEmailID());
//			stmt.setString(3, user.getPassword());
//			stmt.setString(4, user.getRole());
//			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}
//
//	public User getUser(User user) {
//		// TODO Auto-generated method stub
//		try {
//			String sql = "SELECT * FROM User";
//			stmt = conn.prepareStatement(sql);
//		     ResultSet rs = stmt.executeQuery(sql);
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
////			stmt = conn.prepareStatement(sql);
////			stmt.setString(1, user.getEmailID());
////			stmt.setString(2, user.getPassword());
////			stmt.executeUpdate();
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
////			stmt = conn.prepareStatement(sql);
////			stmt.setString(1, user.getEmailID());
////			stmt.setString(2, user.getPassword());
////			stmt.executeUpdate();
//		} catch (Exception e) {
//			System.out.println(e);
//		}
//	}



}