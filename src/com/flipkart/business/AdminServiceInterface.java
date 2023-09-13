/**
 * 
 */
package com.flipkart.business;

/**
 * @author kshitij.gupta1
 */
public interface AdminServiceInterface {
	public boolean approveGymOwnerRequest();
	
	public void viewPendingGymOwnerRequests();
	
	public boolean approveGymRegistration();
	
	public void viewPendingGymRegistrations();

}
