/**
 *
 */
package com.flipkart.dao;

/**
 *
 */
public interface CustomerDAOInterface {

	public boolean queryAllGymDB();
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber);
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber);
	public void addBookingListDB(Integer userID, Integer gynID, Integer slotNumber);
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber);
	public void deleteBookingListDB(Integer userID, Integer slotNumber);
	public boolean queryBookingListDB(Integer userID);
	public void queryGymDB(Integer gymID);
	public boolean querySeatsSlotDB(Integer GymID);
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID);
	public Boolean slotFull(Integer gymID, Integer slotNumber);

	public Integer queryCancelBookingDB(Integer UserID, Integer slotNumber);
	public Integer queryUserDBForID(String email, String password, String role);
}