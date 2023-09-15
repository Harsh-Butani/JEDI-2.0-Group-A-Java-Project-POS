/**
 *
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface CustomerServiceInterface {
	public void viewGyms();

	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID);

	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID);

	public void viewAllBookings(Integer userID);

	public void getGymInfo(Integer gymID);

	// public void checkBookingList();

	public void checkAvailableSlots(Integer gymID);
}