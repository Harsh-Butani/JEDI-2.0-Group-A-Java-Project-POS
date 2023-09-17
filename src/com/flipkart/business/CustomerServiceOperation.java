package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */

import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;


public class CustomerServiceOperation implements CustomerServiceInterface{
	CustomerDAOInterface dao;

	public CustomerServiceOperation() {
		dao = new CustomerDAOImplementation();
	}

	@Override
	public void viewGyms() {
		dao.queryAllGymDB();
	}

	@Override
	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) throws SlotFullException {
		if(dao.slotFull(gymID, slotNumber)) {
			throw new SlotFullException(gymID, slotNumber);
		}
		if(dao.queryBookingListDB(userID, slotNumber)) {
			try {
				cancelBookedSlots(slotNumber, userID);
			} catch (SlotNotBookedException e) {
				e.printStackTrace();
			}
		}
		dao.decreaseSeatsSlotDB(gymID, slotNumber);
		dao.addBookingListDB(userID, gymID, slotNumber);
		return true;
	}

	@Override
	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) throws SlotNotBookedException {
		if(!dao.queryBookingListDB(userID, slotNumber)) {
			throw new SlotNotBookedException(gymID, slotNumber);
		}
		dao.increaseSeatsSlotDB(gymID, slotNumber);
		dao.deleteBookingListDB(userID, slotNumber);
		return true;
	}

	@Override
	public boolean cancelBookedSlots(Integer slotNumber, Integer userID) throws SlotNotBookedException {
		Integer oldGymID = dao.queryCancelBookingDB(userID, slotNumber);
		dao.increaseSeatsSlotDB(oldGymID, slotNumber);
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