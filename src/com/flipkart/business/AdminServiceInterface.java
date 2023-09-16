/**
 * 
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface AdminServiceInterface {
	public boolean approveGymOwnerRequest(Integer GymOwnerID);

	public boolean approveAllGymOwnerRequest();
	
	public void viewPendingGymOwnerRequests();
	
	public boolean approveGymRegistration(Integer gymID);

	public  boolean approveAllGymRegistration();
	
	public void viewPendingGymRegistrations();

}
