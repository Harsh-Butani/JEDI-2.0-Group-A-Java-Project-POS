/**
 * 
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface CustomerServiceInterface {
	public void viewGyms();
	
	public boolean bookSlot(String gymID, Integer slotNumber, String userID);
	
	public boolean cancelBookedSlots(String gymID, Integer slotNumber, String userID);
	
	public String viewAllBookings(String userID);

	public void getGymInfo(String gymID);
	
	// public void checkBookingList();
	
	public void checkAvailableSlots(String gymID);
}
