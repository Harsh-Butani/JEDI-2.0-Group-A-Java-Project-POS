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
//	Connection conn = null;
//	PreparedStatement stmt = null;
	DatabaseConnector dbc;

	public void init() {
		dbc = new DatabaseConnector();
		dbc.init();
		if (dbc.conn != null) {
			System.out.println("dbc.conn is non null");
		}
		try {
			if (dbc.conn != null) {
				System.out.println("Conn");
			}

			String sql = "insert into User values(?,?,?)";
			// String sql = "UPDATE Employees set age=? WHERE id=?";
			// String sql1="delete from employee where id=?";
			// stmt.setInt(1, 101);
			System.out.println("Before ppt");
			System.out.print(sql);
			dbc.stmt = dbc.conn.prepareStatement(sql); // exception aa raha
			if (dbc.stmt == null) {
				System.out.println("Stmt");
			}
			System.out.println("Before setting mdb");
			// Hard coded data
			// Bind values into the parameters.
			int x = 15;
			String t = "abc";
			String u = "def";
			dbc.stmt.setInt(1, x); // This would set age
			dbc.stmt.setString(2, t);
			dbc.stmt.setString(3, u);
	      System.out.println("Before executing");
	      try {
			dbc.stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println("After executing");
//	      String sql1 = "SELECT * FROM FlipFit.User";
//	      ResultSet rs = DatabaseConnector.stmt.executeQuery(sql);
//	      while(rs.next()){
//		         //Retrieve by column name
//		         int eid  = rs.getInt("userID");
//		         String email = rs.getString("email");
//		         String password = rs.getString("password");
//		         // String location1 = rs.getString("location");
//
//		         //Display values
//		         System.out.print("ID: " + eid);
//		         System.out.print(", Age: " + email);
//		         System.out.print(", First: " + password);
//		         // System.out.println(", Last: " + location1);
//		      }
//	   
			/*
			 * 
			 * // Let us update age of the record with ID = 102; int rows =
			 * stmt.executeUpdate(); System.out.println("Rows impacted : " + rows );
			 * 
			 * // Let us select all the records and display them. sql =
			 * "SELECT id, name ,address, location FROM employeefc"; ResultSet rs =
			 * stmt.executeQuery(sql);
			 * 
			 * //STEP 5: Extract data from result set while(rs.next()){ //Retrieve by column
			 * name int eid = rs.getInt("id"); String name1 = rs.getString("name"); String
			 * address1 = rs.getString("address"); String location1 =
			 * rs.getString("location");
			 * 
			 * //Display values System.out.print("ID: " + eid); System.out.print(", Age: " +
			 * name1); System.out.print(", First: " + address1);
			 * System.out.println(", Last: " + location1); }
			 */
			// STEP 6: Clean-up environment
			// rs.close();
			dbc.stmt.close();
			dbc.conn.close();
		} catch (Exception e) {
			System.out.println("Nahi karna kuch");
			System.out.println(e);
		}
		
	}

	@Override
	public void insertUserDB(User user) {
		// TODO Auto-generated method stub
//		try {
//			if(dbc.conn != null) {
//				System.out.println("Conn");
//			}
//			
//		String sql="insert into User values(?,?,?)";
//	      //String sql = "UPDATE Employees set age=? WHERE id=?";
//	     // String sql1="delete from employee where id=?";
//	     // stmt.setInt(1, 101);
//		System.out.println("Before ppt");
//	      dbc.stmt = dbc.conn.prepareStatement(sql); // exception aa raha
//	      if(dbc.stmt == null) {
//				System.out.println("Stmt");
//			}
//	   System.out.println("Before setting mdb");
//	      // Hard coded data 
//	      //Bind values into the parameters.
//	   int x=15;
//	   String t="abc";
//	   String u="def";
//	      dbc.stmt.setInt(1, x);  // This would set age
//	      dbc.stmt.setString(2,t);
//	      dbc.stmt.setString(3, u);
////	      System.out.println("Before executing");
////	      DatabaseConnector.stmt.executeUpdate();
////	      System.out.println("After executing");
////	      String sql1 = "SELECT * FROM FlipFit.User";
////	      ResultSet rs = DatabaseConnector.stmt.executeQuery(sql);
////	      while(rs.next()){
////		         //Retrieve by column name
////		         int eid  = rs.getInt("userID");
////		         String email = rs.getString("email");
////		         String password = rs.getString("password");
////		         // String location1 = rs.getString("location");
////
////		         //Display values
////		         System.out.print("ID: " + eid);
////		         System.out.print(", Age: " + email);
////		         System.out.print(", First: " + password);
////		         // System.out.println(", Last: " + location1);
////		      }
////	   
//	   /*
//	   
//	   // Let us update age of the record with ID = 102;
//	      int rows = stmt.executeUpdate();
//	      System.out.println("Rows impacted : " + rows );
//
//	      // Let us select all the records and display them.
//	      sql = "SELECT id, name ,address, location FROM employeefc";
//	      ResultSet rs = stmt.executeQuery(sql);
//
//	      //STEP 5: Extract data from result set
//	      while(rs.next()){
//	         //Retrieve by column name
//	         int eid  = rs.getInt("id");
//	         String name1 = rs.getString("name");
//	         String address1 = rs.getString("address");
//	         String location1 = rs.getString("location");
//
//	         //Display values
//	         System.out.print("ID: " + eid);
//	         System.out.print(", Age: " + name1);
//	         System.out.print(", First: " + address1);
//	         System.out.println(", Last: " + location1);
//	      }*/
//	      //STEP 6: Clean-up environment
//	     // rs.close();
//	      dbc.stmt.close();
//	      dbc.conn.close();
//		}
//		catch(Exception e) {
//			System.out.println("Nahi karna kuch");
//			System.out.println(e);
//		}
	}

	@Override
	public void insertGymDB(GymDetails gym) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBookingListDB(BookingList list) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertSlotCatalogDB(SlotCatalogDetails slot) {
		// TODO Auto-generated method stub

	}

}
