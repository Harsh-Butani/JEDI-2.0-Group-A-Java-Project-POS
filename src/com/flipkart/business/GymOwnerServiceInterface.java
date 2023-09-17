/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;

/**
 * @author kshitij.gupta1
 */
public interface GymOwnerServiceInterface {
	public boolean registerGym(GymDetails gym);
	public void viewMyGyms(Integer gymOwnerID);
	public Integer fetchGymID(Integer gymOwnerID, String gymName, String gymAddress);
	public void addSlots(SlotCatalogDetails slot);
}
