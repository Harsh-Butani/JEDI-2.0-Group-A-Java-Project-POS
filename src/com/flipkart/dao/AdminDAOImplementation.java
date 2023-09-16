/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 
 */
public class AdminDAOImplementation implements AdminDAOInterface{

	@Override
	public void approveGymOwnerDB(Integer gymOwnerID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_OWNER_QUERY);
			stmt.setInt(1, gymOwnerID);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void approveAllGymOwnerDB() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_PENDING_GYM_OWNER_QUERY);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void queryGymOwnerDB() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_PENDING_GYM_OWNER_REQUEST_QUERY);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String gymOwnerID = rs.getString("GymOwnerID");
				String gymOwnerName = rs.getString("name");
				String gymOwnerAddress = rs.getString("address");
				System.out.println("GymOwnerID: " + gymOwnerID + ", GymOwnerName: " + gymOwnerName + "gymOwnerAddress: " + gymOwnerAddress);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void approveGymDB(Integer gymID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_REGISTRATION_QUERY);
			stmt.setInt(1, gymID);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void approveAllGymDB() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_PENDING_GYM_REGISTRATION_QUERY);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void queryGymDB() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_PENDING_GYM_REGISTRATION_REQUEST_QUERY);
			ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					String gymID = rs.getString("GymID");
					String gymOwnerID = rs.getString("GymOwnerID");
					String gymName = rs.getString("gymName");
					String gymAddress = rs.getString("gymAddress");
					System.out.println("GymID: " + gymID + "GymOwnerID: " + gymOwnerID + ", GymName: " + gymName + "gymAddress: " + gymAddress);
				}

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
