/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;
import com.flipkart.business.AdminServiceOperation;
import com.flipkart.business.AdminServiceInterface;

/**
 * 
 */
public class GymFlipFitAdminMenu {
	public static void adminMenu(Scanner in) {
		while(true) {
			System.out.println("----Admin Menu----");
			System.out.println("Press 1 for approving gym owner request");
			System.out.println("Press 2 for viewing pending gym owner requsts");
			System.out.println("Press 3 for approving gym registration requests");
			System.out.println("Press 4 for viewing pending gym registration requests");
			System.out.println("Press 5 to exit");
			
			int option = in.nextInt();
			AdminServiceInterface admin = new AdminServiceOperation();
			switch(option) {
				case 1:
					if(admin.approveGymOwnerRequest()) {
						System.out.println("Approved");
					}
					break;
				case 2:
					admin.viewPendingGymOwnerRequests();
					break;
				case 3:
					if(admin.approveGymRegistration()) {
						System.out.println("Approved");
					}
					break;
				case 4:
					admin.viewPendingGymRegistrations();
					break;
				case 5:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
