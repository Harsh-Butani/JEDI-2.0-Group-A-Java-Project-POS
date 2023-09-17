package com.flipkart.business;

import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;

/**
 * @author kshitij.gupta1
 */
public class AdminServiceOperation implements AdminServiceInterface{
	AdminDAOInterface dao;
	public AdminServiceOperation(){
		dao = new AdminDAOImplementation();

	}

	@Override
	public boolean approveGymOwnerRequest(Integer GymOwnerID) {
		// TODO Auto-generated method stub
		dao.approveGymOwnerDB(GymOwnerID);
		return true;
	}

	@Override
	public boolean approveAllGymOwnerRequest() {
		dao.approveAllGymOwnerDB();
		return true;
	}

	@Override
	public boolean viewPendingGymOwnerRequests() {
		// TODO Auto-generated method stub
		return dao.queryGymOwnerDB();
		
	}

	@Override
	public boolean approveGymRegistration(Integer gymID) {
		// TODO Auto-generated method stub
		dao.approveGymDB(gymID);
		return true;
	}

	@Override
	public boolean approveAllGymRegistration() {
		dao.approveAllGymDB();
		return true;
	}

	@Override
	public boolean viewPendingGymRegistrations() {
		// TODO Auto-generated method stub
		return dao.queryGymDB();
		
	}
	
}
