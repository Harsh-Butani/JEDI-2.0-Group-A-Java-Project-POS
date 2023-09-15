package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;

/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{
	CustomerDAOImplementation dao;
	public VerificationServiceOperation(){
		dao = new CustomerDAOImplementation();
		dao.init();
		System.out.println("dao created in verification");
	}
	@Override
	public boolean verifyCredentials(User user) {
		User isRegisteredUser = dao.getUser(user);
		if(isRegisteredUser!=null) {
			return true;
		}
		return false;
	}

}