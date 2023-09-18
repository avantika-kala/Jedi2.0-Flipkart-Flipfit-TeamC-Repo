/**
 * 
 */
package com.flipkart.application;

import java.util.*;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Notification;
import com.flipkart.bean.User;
import com.flipkart.business.AdminServiceInterface;
import com.flipkart.business.AdminServiceOperation;
import com.flipkart.business.NotificationServiceInterface;
import com.flipkart.business.NotificationServiceOperation;
import com.flipkart.constants.Constants;

/**
 * @author rohit.r10
 */
public class GymFlipFitAdminMenu {

	AdminServiceInterface adminService = AdminServiceOperation.getInstance();
	NotificationServiceInterface notificationService = NotificationServiceOperation.getInstance();
	List<GymOwner> pendingGymOwnerApprovals = new ArrayList<GymOwner>();
	
	public void displayMenu(User user, Scanner in) {
		int menuOption = 1;
		List<GymOwner> gymOwnerList = new ArrayList<GymOwner>();
		List<Gym> gymList = new ArrayList<Gym>();
		do {
			System.out.println("\n\n \033[1m  --------------- Admin Menu Options ---------------\033[0m "
					+ "\nGym Owner Options:\n\tPress 1. View Pending Registration Request" + "\n\tPress 2. Approve/Reject Registration"
					+ "\n\tPress 3. Approve ALL Pending Registration Requests"
					+ "\nGym Options: \n\tPress 4. View Pending Gym Registration" + "\n\tPress 5. Approve/Reject Gym Registration"
					+ "\n\tPress 6. Approve ALL Gym Registration Requests" +"\nPress 7. Quit");
			menuOption = in.nextInt();
			switch (menuOption) {
			case 1:
				gymOwnerList = adminService.getPendingGymOwnerApprovals();
				System.out.println("UserID\tUsername\tName\tAadhar Card #\tGSTIN#\t\t\tPAN Card\tAddress\t\tPincode");
				System.out.println("---------------------------------------------------------------------------------------------------");
				gymOwnerList.forEach(gymOwner -> System.out.println(gymOwner.getUserID() + "\t" + gymOwner.getUserName() + "\t\t"
							+gymOwner.getName() + "\t" + gymOwner.getAadharCard() + "\t" + gymOwner.getGstIN()
							+ "\t\t" + gymOwner.getPanCard()+ "\t" + gymOwner.getAddress()
							+ "\t" + gymOwner.getPINCode()));

				break;
			case 2:
				System.out.println("Enter gym owner user id");
				int gymId = in.nextInt();
				System.out.println("Press 1. Approve\nPress 2. Reject\n");				
				int newStatus = in.nextInt();
				adminService.handleGymOwnerRequest(gymId, newStatus);
				break;
			case 3:
				adminService.approveAllGymOwners();
				break;
			case 4:
				gymList = adminService.getPendingGymRegistrationRequests();
				System.out.println("GymID\tName\tLocation\t# of seats");
				System.out.println("-----------------------------------------------------------");
				gymList.forEach(gym -> System.out.println(gym.getGymID() + "\t" + gym.getGymName()+ "\t" + gym.getLocation() + "\t\t" + gym.getNoOfSeats()));

				break;
			case 5:
				System.out.println("Enter gym id");
				gymId = in.nextInt();
				System.out.println("Press 1. Approve\nPress 2. Reject\n");
				newStatus = in.nextInt();
				int success = adminService.handleGymRegistrationRequest(gymId, newStatus);
				if(success > 0) {
					for(Gym gym : gymList) {
						if(gym.getGymID() == gymId) {
							String message = (newStatus == Constants.APPROVED ? Constants.NOTIFICATION_APPROVED : Constants.NOTIFICATION_REJECTED )+ gym.getGymName();
							notificationService.addNotification(new Notification(gym.getGymOwnerID(), Constants.ROLE_GYMOWNER, message, false));
							System.out.println("Notification Sent to the Gym Owner!");
							break;
						}
					}
					
				}
				break;
			case 6:
				adminService.approveAllGymRegistrationRequests();
				break;

			case 7:
				System.out.println("\033[1m Exiting Admin Menu.. \033[0m");
				break;
			default:
				System.out.println("You have selected invalid option please try again!!");
				break;
			}
		} while (menuOption != 7);

	}

}
