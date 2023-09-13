/**
 * 
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface CustomerServiceInterface {
	public void viewGyms();
	
	public boolean bookSlot();
	
	public boolean cancelBookedSlots();
	
	public String viewAllBookings();

	public void getGymInfo();
	
	public void checkBookingList();
	
	public void checkAvailableSlots();
}
