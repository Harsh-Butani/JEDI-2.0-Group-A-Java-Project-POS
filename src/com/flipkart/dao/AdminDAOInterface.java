/**
 * 
 */
package com.flipkart.dao;

/**
 * @author kshitij.gupta1
 */
public interface AdminDAOInterface {
	public void approveGymOwnerDB(Integer gymOwnerID);
	public void approveAllGymOwnerDB();
	public boolean queryGymOwnerDB();
	public void approveGymDB(Integer gymID);

	public void approveAllGymDB();
	public boolean queryGymDB();

}
