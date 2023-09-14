/**
 * 
 */
package com.flipkart.business;

import java.util.List;

import com.flipkart.bean.User;

/**
 * @author kshitij.gupta1
 */
public interface VerificationServiceInterface {
	public boolean verifyCredentials(User user, List<User> userDetails);


}