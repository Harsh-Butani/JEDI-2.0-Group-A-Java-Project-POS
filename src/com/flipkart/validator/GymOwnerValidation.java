/**
 * 
 */
package com.flipkart.validator;

import com.flipkart.exception.InvalidAadharException;

/**
 * 
 */
public class GymOwnerValidation {
	private static Integer aadhar;
	public GymOwnerValidation(Integer aadhar) {
		GymOwnerValidation.aadhar = aadhar;
	}
	
	public static boolean checkAadhar(Integer aadhar) throws InvalidAadharException {
		int cnt=0;
		while(aadhar>0) {
			cnt++;
			aadhar/=10;
		}
		if(cnt!=12) {
			throw new InvalidAadharException();
		}
		return true;
	}
}
