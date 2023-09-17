/**
 *
 */
package com.flipkart.dao;

/**
 *
 */
public interface CustomerDAOInterface {
//	public void init();
//	public void insertUserDB(User user);
//	public void insertGymDB(GymDetails gym);
//	public void insertBookingListDB(BookingList list);
//	public void insertSlotCatalogDB(SlotCatalogDetails slot);
//
//	public void updateUserDB(User user, String password);
//
//	public User getUser(User user);

	public void queryAllGymDB();
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber);
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber);
	public void addBookingListDB(Integer userID, Integer gynID, Integer slotNumber);
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber);
	public void deleteBookingListDB(Integer userID, Integer slotNumber);
	public void queryBookingListDB(Integer userID);
	public void queryGymDB(Integer gymID);
	public void querySeatsSlotDB(Integer GymID);
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID);
	public Boolean slotFull(Integer gymID, Integer slotNumber);
}