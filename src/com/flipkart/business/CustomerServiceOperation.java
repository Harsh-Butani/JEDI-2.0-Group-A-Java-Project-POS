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
	CustomerDAOInterface dao;

	public CustomerServiceOperation() {
		dao = new CustomerDAOImplementation();
		System.out.println("Created a new dao object");
	}

	@Override
	public void viewGyms() {
		dao.queryAllGymDB();
	}

	@Override
	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) {
		if(dao.queryBookingListDB(userID, slotNumber)) {
			cancelBookedSlots(gymID, slotNumber, userID);
		}
		dao.decreaseSeatsSlotDB(gymID, slotNumber);
		dao.addBookingListDB(userID, gymID, slotNumber);
		return true;
	}

	@Override
	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) {
		if(!dao.queryBookingListDB(userID, slotNumber, gymID)) {
			System.out.println("There exists no such booking");
			return false;
		}
		dao.increaseSeatsSlotDB(gymID, slotNumber);
		dao.deleteBookingListDB(userID, slotNumber);
		return true;
	}

	@Override
	public void viewAllBookings(Integer userID) {
		dao.queryBookingListDB(userID);
	}

	@Override
	public void getGymInfo(Integer gymID) {
		dao.queryGymDB(gymID);
	}

//	@Override
//	public void checkBookingList() {
//		// TODO Auto-generated method stub
//		System.out.println("Checking booking list");
//
//	}

	@Override
	public void checkAvailableSlots(Integer gymID) {
		dao.querySeatsSlotDB(gymID);
	}
}