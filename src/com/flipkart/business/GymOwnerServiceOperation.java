package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
public class GymOwnerServiceOperation implements GymOwnerServiceInterface{

	@Override
	public boolean registerGym() {
		// TODO Auto-generated method stub
		System.out.println("Cannot register gym");
		return false;
	}

	@Override
	public String viewMyGyms() {
		// TODO Auto-generated method stub
		System.out.println("Can't view your gyms as you don't have any");
		return null;
	}
	
}
