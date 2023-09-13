package com.flipkart.bean;

public class GymOwner {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getIDProof() {
		return IDProof;
	}
	public void setIDProof(int iDProof) {
		IDProof = iDProof;
	}
	public String getGymOwnerID() {
		return gymOwnerID;
	}
	public void setGymOwnerID(String gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}
	private String address;
	private int IDProof;
	private String gymOwnerID;
}
