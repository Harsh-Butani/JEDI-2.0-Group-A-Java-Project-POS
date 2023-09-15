/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserDAOInterface {
	public void insertUserDB(User user);
	public void updateUserDB(User user,String password);
	public User getUserDB(User user);

}
