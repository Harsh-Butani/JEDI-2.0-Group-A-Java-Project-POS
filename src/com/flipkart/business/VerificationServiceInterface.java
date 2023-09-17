/**
 * 
 */
package com.flipkart.business;


import com.flipkart.bean.User;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * @author kshitij.gupta1
 */
public interface VerificationServiceInterface {
	public boolean verifyCredentials(User user) throws UserNotRegisteredException;
}