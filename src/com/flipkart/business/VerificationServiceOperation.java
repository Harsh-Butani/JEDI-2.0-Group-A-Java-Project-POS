package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.User;

/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{

	@Override
	public boolean verifyCredentials(User user, List<User> userDetails) {
		// TODO Auto-generated method stub
		String emailID = user.getEmailID();
		String password = user.getPassword();
		String role = user.getRole();
		for(User userCheck: userDetails) {
			String emailID1 = userCheck.getEmailID();
			String password1 = userCheck.getPassword();
			String role1 = userCheck.getRole();

			
			if(emailID.equals(emailID1) && password.equals(password1) && role.equals(role1)) {
				System.out.println("Credentials Verified Successfully");
				return true;
			}
		}
		return false;
	}

}