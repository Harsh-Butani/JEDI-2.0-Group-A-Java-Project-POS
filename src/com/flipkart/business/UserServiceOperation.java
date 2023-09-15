/**
 * 
 */
package com.flipkart.business;

import java.sql.ResultSet;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;

/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{

	UserDAOInterface userDAO;
	public UserServiceOperation() {
		userDAO = new UserDAOImplementation();
	}
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userDAO.insertUserDB(user);
	}
	
	@Override
	public void updateUser(User user, String password) {
		// TODO Auto-generated method stub
		userDAO.updateUserDB(user,password);
	}
	
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.getUserDB(user);	
	}
}
