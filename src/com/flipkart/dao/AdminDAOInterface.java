/**
 * 
 */
package com.flipkart.dao;

/**
 * 
 */
public interface AdminDAOInterface {
	public void approveGymOwnerDB(Integer gymOwnerID);
	public void approveAllGymOwnerDB();
	public void queryGymOwnerDB();
	public void approveGymDB(Integer gymID);

	public void approveAllGymDB();
	public void queryGymDB();

}
