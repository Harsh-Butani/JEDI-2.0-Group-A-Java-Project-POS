package com.flipkart.bean;

public class GymDetails {
	private String gymID;
	public String getGymID() {
		return gymID;
	}
	public void setGymID(String gymID) {
		this.gymID = gymID;
	}
	public boolean isGymApprovalStatus() {
		return gymApprovalStatus;
	}
	public void setGymApprovalStatus(boolean gymApprovalStatus) {
		this.gymApprovalStatus = gymApprovalStatus;
	}
	public String getGymName() {
		return gymName;
	}
	public void setGymName(String gymName) {
		this.gymName = gymName;
	}
	public String getGymAddress() {
		return gymAddress;
	}
	public void setGymAddress(String gymAddress) {
		this.gymAddress = gymAddress;
	}
	private boolean gymApprovalStatus;
	private String gymName;
	private String gymAddress;
}
