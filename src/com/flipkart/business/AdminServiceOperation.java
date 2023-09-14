package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
public class AdminServiceOperation implements AdminServiceInterface{

	@Override
	public boolean approveGymOwnerRequest() {
		// TODO Auto-generated method stub
		System.out.println("Gym owner request not approved");
		return false;
	}

	@Override
	public void viewPendingGymOwnerRequests() {
		// TODO Auto-generated method stub
		System.out.println("Viewing pending gym owner requests");
		
	}

	@Override
	public boolean approveGymRegistration() {
		// TODO Auto-generated method stub
		System.out.println("Gym request not approved");
		return false;
	}

	@Override
	public void viewPendingGymRegistrations() {
		// TODO Auto-generated method stub
		System.out.println("Viewing pending gym requests");
		
	}
	
}
