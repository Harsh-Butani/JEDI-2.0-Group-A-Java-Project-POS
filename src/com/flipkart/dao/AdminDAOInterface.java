/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface AdminDAOInterface {
	public void approveGymOwnerDB(String gymOwnerID);
	public void approveAllGymOwnerDB();
	public void queryGymOwnerDB();
	public void approveGymDB(Integer gymID);
	public void queryGymDB();

}
