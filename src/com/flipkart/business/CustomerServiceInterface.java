/**
 *
 */
package com.flipkart.business;

import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;

/**
 * @author kshitij.gupta1
 */
public interface CustomerServiceInterface {
	public void viewGyms();

	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) throws SlotFullException, SlotNotBookedException;

	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) throws SlotNotBookedException;

	public void viewAllBookings(Integer userID);

	public void getGymInfo(Integer gymID);

	// public void checkBookingList();

	public void checkAvailableSlots(Integer gymID);
}