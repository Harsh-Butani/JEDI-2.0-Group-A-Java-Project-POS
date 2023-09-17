package com.flipkart.business;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;

/**
 * @author kshitij.gupta1
 */
public class GymOwnerServiceOperation implements GymOwnerServiceInterface{

	
	GymOwnerDAOInterface dao;
	public GymOwnerServiceOperation(){
		dao  = new GymOwnerDAOImplementation();
	}
	@Override
	public boolean registerGym(GymDetails gym) {
		// TODO Auto-generated method stub
		dao.insertGymDB(gym.getGymOwnerID(), gym.getGymName(), gym.getGymAddress());
		return true;
	}

	@Override
	public void viewMyGyms(Integer gymOwnerID) {
		// TODO Auto-generated method stub
		dao.queryGymDB(gymOwnerID);
	}
	
	public Integer fetchGymID(Integer gymOwnerID, String gymName, String gymAddress) {
		return dao.queryGymDB(gymOwnerID, gymName, gymAddress);
	}
	
	public void addSlots(SlotCatalogDetails slot) {
		dao.insertSlotDB(slot);
	}
	
	public Integer getGymOwnerID(String email) {
		return dao.getIDFromGymOwnerDB(email);
	}
}
