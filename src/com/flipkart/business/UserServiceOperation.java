/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDAOImplementation;

/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{

	@Override
	UserDAOImplementation userDAO = new UserDAOImplementation();
	userDAO.init();
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		
		
	}

	

}
