/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;

/**
 * 
 */
public class GymFlipFitGymOwnerMenu {
	public static void gymOwnerMenu(Scanner in) {
		while(true) {
			System.out.println("----Gym Owner Menu----");
			System.out.println("Press 1 to register gym");
			System.out.println("Press 2 to view your gyms");
			System.out.println("Press 3 to exit");
			
			int option = in.nextInt();
			GymOwnerServiceInterface gymOwner = new GymOwnerServiceOperation();
			switch(option) {
				case 1:
					if(gymOwner.registerGym()) {
						System.out.println("Successfully registered");
					}
					break;
				case 2:
					gymOwner.viewMyGyms();
					break;
				case 3:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
