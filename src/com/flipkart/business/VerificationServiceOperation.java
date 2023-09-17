package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{
	UserDAOInterface userDAO = new UserDAOImplementation();
	public VerificationServiceOperation(){
		userDAO = new UserDAOImplementation();
	}
	@Override
	public boolean verifyCredentials(User user) throws UserNotRegisteredException {
		User isRegisteredUser = userDAO.getUserDB(user);
		if(isRegisteredUser!=null) {
			return true;
		}
		throw new UserNotRegisteredException(user.getEmailID(), user.getRole());
	}

}