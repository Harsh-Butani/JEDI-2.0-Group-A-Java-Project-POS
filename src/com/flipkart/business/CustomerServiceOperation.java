package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;

import java.sql.SQLException;
import java.util.*;
public class CustomerServiceOperation implements CustomerServiceInterface{
	public static HashMap<String,HashMap<Integer,Integer>> gymMap = new HashMap<>();
	// <gymID> -> <slot number> -> <available seats>
	public static HashMap<Integer, Integer> slotMap1 = new HashMap<>();
	public static HashMap<String, HashMap<Integer,String>> userMap = new HashMap();
	// <userID> -> <slot Number> -> <gymId>
	public static HashMap<Integer,String> innerMap = new HashMap();
	public static HashMap<String, String> gymInfo = new HashMap();
	
	public static void init() {
		// gym 1
//		slotMap1.put(0,30);
//		slotMap1.put(1, 30);
//		slotMap1.put(2, 30);
//		slotMap1.put(9, 30);
//		slotMap1.put(10, 30);
//		slotMap1.put(11, 30);
//		gymMap.put("101",slotMap1);
////		slotMap2.put(0,30);
////		slotMap2.put(1, 30);
////		slotMap2.put(2, 30);
////		slotMap2.put(9, 30);
////		slotMap2.put(10, 30);
////		slotMap2.put(11, 30);
//		//innerMap.put(0, "101");
//		innerMap.put(1, "102");
//		innerMap.put(2, "103");
//		userMap.put("197982", innerMap);
//		gymInfo.put("101", "Gym with ID 101");
//		gymInfo.put("102", "Gym with ID 102");
		CustomerDAOImplementation cdao = new CustomerDAOImplementation();
		cdao.init();
		CustomerDAOInterface dao = new CustomerDAOImplementation();
		User u = new User();
		u.setEmailID("abc.com");
		u.setPassword("password");
		dao.insertUserDB(u);
	}

	@Override
	public void viewGyms() {
		// TODO Auto-generated method stub
		System.out.println("Viewing gyms");
		for(Map.Entry<String, HashMap<Integer,Integer>> set: gymMap.entrySet()) {
			System.out.println("Viewing gym with ID " + set.getKey());
		}
	}

	@Override
	public boolean bookSlot(String gymID, Integer slotNumber, String userID) {
		// TODO Auto-generated method stub
		Integer newValue = gymMap.get(gymID).get(slotNumber) - 1;
		gymMap.get(gymID).put(slotNumber, newValue);
		userMap.get(userID).put(slotNumber,  gymID);
		System.out.println("Successfully booked");
		return true;
	}

	@Override
	public boolean cancelBookedSlots(String gymID, Integer slotNumber, String userID) {
		// TODO Auto-generated method stub
		Integer newValue = gymMap.get(gymID).get(slotNumber) + 1;
		gymMap.get(gymID).put(slotNumber, newValue);
		userMap.get(userID).remove(slotNumber,  gymID);
		System.out.println("Successfully cancelled");
		return true;
	}

	@Override
	public String viewAllBookings(String userID) {
		// TODO Auto-generated method stub
		System.out.println("Viewing all your bookings");
		for(Map.Entry<Integer,String> set: userMap.get(userID).entrySet()) {
			System.out.println("You have a booking at " + set.getValue() +" at slot " + set.getKey());
		}
		return null;
	}
	
	@Override
	public void getGymInfo(String gymID) {
		// TODO Auto-generated method stub
		//System.out.println("No gym info available as no gyms registered");
		System.out.println("Gym Info: "+gymInfo.get(gymID));
	}

//	@Override
//	public void checkBookingList() {
//		// TODO Auto-generated method stub
//		System.out.println("Checking booking list");
//		
//	}

	@Override
	public void checkAvailableSlots(String gymID) {
		// TODO Auto-generated method stub
		// System.out.println("No gym, no slots");
		System.out.println("Showing avaliable slots of gym: " + gymID);
		for(Map.Entry<Integer,Integer> set: gymMap.get(gymID).entrySet()) {
			System.out.println("Slot number: " + set.getKey() + " available seats: " + set.getValue());
		}
	}
}