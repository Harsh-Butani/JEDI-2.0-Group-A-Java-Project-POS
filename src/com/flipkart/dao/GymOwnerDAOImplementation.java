/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
public class GymOwnerDAOImplementation implements GymOwnerDAOInterface{

	@Override
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void queryGymDB(Integer gymOwnerID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertGymOwnerDB(GymOwner gymOwner) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.INSERT_INTO_GYM_OWNER_DB);
			stmt.setString(1,gymOwner.getName());
			stmt.setString(2,gymOwner.getAddress());
			stmt.setInt(3,gymOwner.getIDProof());
			stmt.setInt(4,0);
			stmt.setString(5,gymOwner.getEmailID());
			stmt.setString(6, gymOwner.getPassword());
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}

	}

}
