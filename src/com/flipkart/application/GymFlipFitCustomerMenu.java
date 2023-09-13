/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.CustomerServiceOperation;

/**
 * 
 */
public class GymFlipFitCustomerMenu {
	public static void customerMenu(Scanner in) {
		while(true) {
			System.out.println("----Customer Menu----");
			System.out.println("Press 1 to view gyms");
			System.out.println("Press 2 to book slot");
			System.out.println("Press 3 to cancel booked slots");
			System.out.println("Press 4 to view all bookings");
			System.out.println("Press 5 to view gym info");
			System.out.println("Press 6 to check booking list");
			System.out.println("Press 7 to check available slots");
			System.out.println("Press 8 to exit");
			
			int option = in.nextInt();
			CustomerServiceInterface customer = new CustomerServiceOperation();
			switch(option) {
				case 1:
					customer.viewGyms();
					break;
				case 2:
					if(customer.bookSlot()) {
						System.out.println("Booked");
					}
					break;
				case 3:
					if(customer.cancelBookedSlots()) {
						System.out.println("Cacelled");
					}
					break;
				case 4:
					customer.viewAllBookings();
					break;
				case 5:
					customer.getGymInfo();
					break;
				case 6:
					customer.checkBookingList();
					break;
				case 7:
					customer.checkAvailableSlots();
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
