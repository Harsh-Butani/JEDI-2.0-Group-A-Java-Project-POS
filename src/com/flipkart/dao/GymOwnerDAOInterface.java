/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.SlotCatalogDetails;

/**
 * 
 */
public interface GymOwnerDAOInterface {
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress);
	public boolean queryGymDB(Integer gymOwnerID);
	public void insertGymOwnerDB(GymOwner gymOwner);
	public Integer queryGymDB(Integer gymOwnerID, String gymName, String gymAddress);
	public void insertSlotDB(SlotCatalogDetails slot);
	public Integer getIDFromGymOwnerDB(String email);
}
