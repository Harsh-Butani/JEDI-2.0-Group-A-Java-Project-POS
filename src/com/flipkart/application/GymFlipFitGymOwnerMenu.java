/**
 * 
 */
package com.flipkart.application;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
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
					System.out.println("Enter gymOwner ID");
					Integer gymOwnerID = in.nextInt();
					System.out.println("Enter gym name");
					String gymName = in.next();
					System.out.println("Enter gym address");
					String gymAddress = in.next();
					GymDetails gym = new GymDetails();
					gym.setGymOwnerID(gymOwnerID);
					gym.setGymName(gymName);
					gym.setGymAddress(gymAddress);
					if(gymOwner.registerGym(gym)) {
						System.out.println("Successfully registered");
					}
					System.out.println("Enter number of slots");
					Integer numberOfSlots = in.nextInt();
					System.out.println("Enter maximum seats");
					Integer maxSeats = in.nextInt();
					Integer gymID = gymOwner.fetchGymID(gymOwnerID, gymName, gymAddress);
					for(int i=0;i<numberOfSlots;i++) {
						SlotCatalogDetails slot = new SlotCatalogDetails();
						slot.setAvailableSeats(maxSeats);
						slot.setGymID(gymID);
						slot.setApprovedStatus(0);
						System.out.println("Enter slot number");
						Integer slotNumber = in.nextInt();
						slot.setSlotNumber(slotNumber);
						gymOwner.addSlots(slot);
					}
					break;
				case 2:
					System.out.println("Enter gym owner ID");
					Integer gymOwnerID1 = in.nextInt();
					gymOwner.viewMyGyms(gymOwnerID1);
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
