/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;

/**
 * 
 */
public interface GymOwnerDAOInterface {
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress);
	public void queryGymDB(Integer gymOwnerID);
	public void insertGymOwnerDB(GymOwner gymOwner);

}
