/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.User;

/**
 * 
 */
public interface UserServiceInterface {
	public void registerUser(User user);
	public void updateUser(User user,String password);
	public User getUser(User user);

}
