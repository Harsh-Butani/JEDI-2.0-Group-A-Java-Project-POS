package com.flipkart.application;
import java.util.ArrayList;
import java.util.List;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.business.VerificationServiceOperation;
import com.flipkart.bean.User;
import com.flipkart.business.VerificationServiceInterface;

public class GymFlipFitApplication {

	public static void main(String[] args) {
		// TODO Auto-generated
		List<User> userDetails = new ArrayList<User>();
        System.out.println("Welcome to FlipFit Application for Slot Booking!");
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
        			User userLogin = new User();
        			System.out.println("Enter emailID");
        			userLogin.setEmailID(in.next());
        			System.out.println("Enter password");
        			userLogin.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
        			userLogin.setRole(in.next());
        			VerificationServiceInterface verifier = new VerificationServiceOperation();
        			if(verifier.verifyCredentials(userLogin, userDetails)) {
        				System.out.println("Successfully logged in");
        				if(userLogin.getRole().equals("Customer")) {
            				GymFlipFitCustomerMenu.customerMenu(in);
            			}
            			else if(userLogin.getRole().equals("GymOwner")) {
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
        			User user  = new User();
        			System.out.println("Enter email ID");
        			user.setEmailID(in.next());
        			
        			System.out.println("Create a password");
        			user.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
        			user.setRole(in.next());
        			user.setID(Integer.toString(userDetails.size()+1));
        			userDetails.add(user);
        			System.out.println("Registration complete");
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
        			flag = true;
        			break;
        		default:
        			System.out.println("Please enter a valid option.");
        			break;
        	}
        	if(flag) {
        		break;
        	}
        }
		
	}
}