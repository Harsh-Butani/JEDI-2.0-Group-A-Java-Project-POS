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
	public boolean viewGyms();

	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) throws SlotFullException, SlotNotBookedException;

	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) throws SlotNotBookedException;

	public boolean viewAllBookings(Integer userID);

	public void getGymInfo(Integer gymID);

	// public void checkBookingList();

	public boolean checkAvailableSlots(Integer gymID);

	public boolean cancelBookedSlots(Integer slotNumber, Integer userID) throws SlotNotBookedException;

}