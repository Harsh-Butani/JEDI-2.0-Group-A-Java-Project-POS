/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * @author kshitij.gupta1
 */
public interface UserDAOInterface {
	public void insertUserDB(User user);
	public void updateUserDB(User user,String password);
//	public User getUserDB(User user);
	public Boolean queryUserDB(User user);
	public Boolean queryDetailsUserDB(User user);
}
