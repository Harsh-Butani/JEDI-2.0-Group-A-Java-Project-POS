/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface GymOwnerDAOInterface {
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress);
	public void queryGymDB(Integer gymOwnerID);

}
