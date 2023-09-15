package com.flipkart.bean;

/**
 * @author kshitij.gupta1
 */
public class User {
	private String emailID;
	private String password;
	private String role;
	private static int userID;
	
	public User() {
	}
	
	public User(boolean newUser) {
		if(newUser) {			
			User.userID += 1;
		}
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
