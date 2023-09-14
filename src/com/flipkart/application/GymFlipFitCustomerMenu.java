/**
 * 
 */
package com.flipkart.application;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.CustomerServiceOperation;

/**
 * 
 */
public class GymFlipFitCustomerMenu {
	public static void customerMenu(Scanner in) {
//		CustomerServiceOperation cs = new CustomerServiceOperation();
//		CustomerServiceOperation.init();
//		cs.viewGyms();
//		cs.viewAllBookings("197982");
//		cs.checkAvailableSlots("101");
//		cs.getGymInfo("101");
//		cs.bookSlot("101", 0, "197982");
//		cs.viewAllBookings("197982");
//		cs.checkAvailableSlots("101");
//		cs.cancelBookedSlots("101", 0, "197982");
//		cs.viewAllBookings("197982");
//		cs.checkAvailableSlots("101");
		
		CustomerServiceInterface customer = new CustomerServiceOperation();
		CustomerServiceOperation.init();
		System.out.println("Enter User ID: ");
		String UserID = in.next();
		
		while(true) {
			System.out.println("----Customer Menu----");
			System.out.println("Press 1 to view gyms");
			System.out.println("Press 2 to book slot");
			System.out.println("Press 3 to cancel booked slots");
			System.out.println("Press 4 to view all bookings");
			System.out.println("Press 5 to view gym info");
			//System.out.println("Press 6 to check booking list");
			System.out.println("Press 7 to check available slots");
			System.out.println("Press 8 to exit");
			
			int option = in.nextInt();
			switch(option) {
				case 1:
					customer.viewGyms();
					break;
				case 2:
					System.out.println("Enter gym ID");
					String gymID = in.next();
					System.out.println("Enter slot number");
					Integer slotnumber = in.nextInt();
					customer.bookSlot(gymID, slotnumber, UserID);
					break;
				case 3:
					System.out.println("Enter gym ID");
					gymID = in.next();
					System.out.println("Enter slot number");
					slotnumber = in.nextInt();
					customer.cancelBookedSlots(gymID, slotnumber, UserID);
					break;
				case 4:
					customer.viewAllBookings(UserID);
					break;
				case 5:
					System.out.println("Enter Gym ID: ");
					String GymID = in.next();
					customer.getGymInfo(GymID);
					break;
				case 6:
					//customer.checkBookingList();
					break;
				case 7:
					System.out.println("Enter Gym ID: ");
					GymID = in.next();
					customer.checkAvailableSlots(GymID);
					break;
				case 8:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
