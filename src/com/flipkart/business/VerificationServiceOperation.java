package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{

	@Override
	public boolean verifyCredentials(String emailID, String password) {
		// TODO Auto-generated method stub
		System.out.println("Successfully verified");
		return true;
	}

}
