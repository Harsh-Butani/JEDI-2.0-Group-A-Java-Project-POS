/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.exception.AlreadyRegisteredException;

/**
 * 
 */
public interface UserServiceInterface {
	public void registerUser(User user) throws AlreadyRegisteredException;
	public void updateUser(User user,String password);
	public User getUser(User user);
	public void registerGymOwner(GymOwner gymOwner);

}
