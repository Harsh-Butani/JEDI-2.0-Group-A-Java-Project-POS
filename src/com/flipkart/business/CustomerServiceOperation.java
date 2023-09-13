package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
public class CustomerServiceOperation implements CustomerServiceInterface{

	@Override
	public void viewGyms() {
		// TODO Auto-generated method stub
		System.out.println("Viewing gyms");
	}

	@Override
	public boolean bookSlot() {
		// TODO Auto-generated method stub
		System.out.println("Unsuccessful attempt at booking slots");
		return false;
	}

	@Override
	public boolean cancelBookedSlots() {
		// TODO Auto-generated method stub
		System.out.println("Cannot cancel your booking");
		return false;
	}

	@Override
	public String viewAllBookings() {
		// TODO Auto-generated method stub
		System.out.println("Viewing your bookings");
		return null;
	}
	
	@Override
	public void getGymInfo() {
		// TODO Auto-generated method stub
		System.out.println("No gym info available as no gyms registered");
	}

	@Override
	public void checkBookingList() {
		// TODO Auto-generated method stub
		System.out.println("Checking booking list");
		
	}

	@Override
	public void checkAvailableSlots() {
		// TODO Auto-generated method stub
		System.out.println("No gym, no slots");
	}
}