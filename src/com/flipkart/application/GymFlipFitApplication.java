package com.flipkart.application;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.business.VerificationServiceOperation;
import com.flipkart.business.VerificationServiceInterface;

public class GymFlipFitApplication {

	public static void main(String[] args) {
		// TODO Auto-generated
        System.out.println("Welcome to Flipfit Application for Slot Booking!");
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.println("----Menu----");
        	System.out.println("Press 1 for Login");
        	System.out.println("Press 2 for Registration of Customer");
        	System.out.println("Press 3 for Updating Password");
        	System.out.println("Press 4 to Exit");
        	
        	int option = in.nextInt();
        	String emailID, password,role;
        	boolean flag = false;
        	switch (option) {
        		case 1:
        			System.out.println("Enter emailID");
        			emailID = in.next();
        			System.out.println("Enter password");
        			password = in.next();
        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
        			role = in.next();
        			VerificationServiceInterface verifier = new VerificationServiceOperation();
        			if(verifier.verifyCredentials(emailID, password)) {
        				System.out.println("Successfully logged in");
        				if(role.equals("Customer")) {
            				GymFlipFitCustomerMenu.customerMenu(in);
            			}
            			else if(role.equals("GymOwner")) {
            				GymFlipFitGymOwnerMenu.gymOwnerMenu(in);
            			}
            			else {
            				GymFlipFitAdminMenu.adminMenu(in);
            			}
        			}
        			else {
        				System.out.println("Incorrect/Invalid credentials");
        			}
        			break;
        		case 2:
        			System.out.println("Enter email ID");
        			emailID = in.next();
        			System.out.println("Create a password");
        			password = in.next();
//        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
//        			role = in.next();
        			System.out.println("Enter name");
        			String name = in.next();
        			System.out.println("Enter address");
        			String address = in.next();
        			System.out.println("Registration complete");
//        			if(role.equals("Customer")) {
//        				GymFlipFitCustomerMenu.customerMenu(in);
//        			}
//        			else if(role.equals("GymOwner")) {
//        				GymFlipFitGymOwnerMenu.gymOwnerMenu(in);
//        			}
//        			else {
//        				GymFlipFitAdminMenu.adminMenu(in);
//        			}
        			break;
        		case 3:
        			System.out.println("Enter current password");
        			String currentPassword = in.next();
        			System.out.println("Enter new password");
        			String newPassword = in.next();
        			System.out.println("Successfully changed the password");
        			break;
        		case 4:
        			in.close();
        			// return;
        			flag = true;
        			break;
        		default:
        			System.out.println("Enter a valid option");
        			break;
        	}
        	if(flag) {
        		break;
        	}
        }
		
	}
}
