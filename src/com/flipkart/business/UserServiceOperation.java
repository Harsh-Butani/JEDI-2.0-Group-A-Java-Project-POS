/**
 * 
 */
package com.flipkart.business;


import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;
import com.flipkart.exception.AlreadyRegisteredException;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;

/**
 * 
 */
public class UserServiceOperation implements UserServiceInterface{

	UserDAOInterface userDAO;
	GymOwnerDAOInterface gymOwnerDAO;
	public UserServiceOperation() {
		userDAO = new UserDAOImplementation();
		gymOwnerDAO = new GymOwnerDAOImplementation();
	}
	@Override
	public void registerUser(User user) throws AlreadyRegisteredException {
		// TODO Auto-generated method stub
		if(userDAO.queryUserDB(user)) {
			throw new AlreadyRegisteredException(user.getEmailID(), user.getRole());
		}
		userDAO.insertUserDB(user);
	}
	
	@Override
	public void updateUser(User user, String password) {
		// TODO Auto-generated method stub
		userDAO.updateUserDB(user,password);
	}
	
//	@Override
//	public User getUser(User user) {
//		// TODO Auto-generated method stub
//		return userDAO.getUserDB(user);	
//	}

	@Override
	public void registerGymOwner(GymOwner gymOwner) {
		gymOwnerDAO.insertGymOwnerDB(gymOwner);
	}
}
