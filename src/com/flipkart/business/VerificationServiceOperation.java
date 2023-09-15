package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;

/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{
	UserDAOInterface userDAO = new UserDAOImplementation();
	public VerificationServiceOperation(){
		userDAO = new UserDAOImplementation();
	}
	@Override
	public boolean verifyCredentials(User user) {
		User isRegisteredUser = userDAO.getUserDB(user);
		if(isRegisteredUser!=null) {
			return true;
		}
		return false;
	}

}