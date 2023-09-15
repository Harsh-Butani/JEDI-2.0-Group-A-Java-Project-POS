/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.BookingList;
import com.flipkart.bean.GymDetails;
import com.flipkart.bean.User;
import com.flipkart.bean.SlotCatalogDetails;

/**
 * 
 */
public interface CustomerDAOInterface {
	public void insertUserDB(User user);
	public void insertGymDB(GymDetails gym);
	public void insertBookingListDB(BookingList list);
	public void insertSlotCatalogDB(SlotCatalogDetails slot);
}
