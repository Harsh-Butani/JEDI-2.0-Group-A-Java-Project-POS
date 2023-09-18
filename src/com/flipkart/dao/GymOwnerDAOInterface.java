/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.SlotCatalogDetails;

/**
 * @author kshitij.gupta1
 */
public interface GymOwnerDAOInterface {

	/**
	 * Dao method used to insert a new gym into the gymDB
	 * @param gymOwnerID
	 * @param gymName
	 * @param gymAddress
	 */
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress);


	/**
	 * Dao method used to print details of all gyms of a particular GymOwner from GymDB
	 * @param gymOwnerID
	 * @return whether gym owner has any gyms
	 */
	public boolean queryGymDB(Integer gymOwnerID);


	/**
	 * Dao method used to add a new gymOwner with all their details into the GymOwnerDB
	 * @param gymOwner
	 */
	public void insertGymOwnerDB(GymOwner gymOwner);


	/**
	 * Dao method to query GymDB and return GymID associated with passed details
	 * @param gymOwnerID
	 * @param gymName
	 * @param gymAddress
	 * @return GymID associated with gym
	 */
	public Integer queryGymDB(Integer gymOwnerID, String gymName, String gymAddress);


	/**
	 * Dao method to insert a slot into slotDB
	 * @param slot
	 */
	public void insertSlotDB(SlotCatalogDetails slot);


	/**
	 * Dao method to get gymOwnerID from GymownerDB associated with email
	 * @param email
	 * @return gymOwnerID associated with details
	 */
	public Integer getIDFromGymOwnerDB(String email);
}
