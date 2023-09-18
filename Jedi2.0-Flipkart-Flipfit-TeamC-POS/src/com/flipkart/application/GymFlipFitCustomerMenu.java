/**
 * 
 */
package com.flipkart.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.TimeSlot;
import com.flipkart.bean.User;
import com.flipkart.business.BookingServiceOperation;
import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.CustomerServiceOperation;
import com.flipkart.business.GymServiceInterface;
import com.flipkart.business.GymServiceOperation;
import com.flipkart.business.TimeSlotOperation;

/**
 * @author rohit.r10
 */
public class GymFlipFitCustomerMenu {
	CustomerServiceInterface customerService = CustomerServiceOperation.getInstance();
	GymServiceInterface gymService = GymServiceOperation.getInstance();

	public void displayMenu(User user, Scanner in) {
		int menuOption = 1;
		do {
			System.out.println("\n\n ------ Customer Menu Options ------ " +"\nPress 1. View available gyms"+"\nPress 2. Book a slot" + "\nPress 3. Cancel Booking "
					+ "\nPress 4. View my bookings" +"\nPress 5. View Profile" +"\nPress 6. Quit");
			menuOption = in.nextInt();
			switch (menuOption) {
				case 1:
					System.out.println("GymID\tGymName\t\tLocation");
					System.out.println("-----------------------------------------------------------");
					
					gymService.viewGymList().forEach(gym -> System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t\t"
								+ gym.getLocation()));
					
//					for (Gym gym : gymService.viewGymList()) {
//						System.out.println(gym.getGymID() + "\t" + gym.getGymName() + "\t\t"
//								+ gym.getLocation());
//					}
					break;
				case 2:
					ArrayList<TimeSlot> slots = TimeSlotOperation.getInstance().getAllAvailableSlots();
					System.out.println("\n********************* Available Slots ****************\n");
					System.out.println("Slot No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------");
					int index = 1;
										
					for(TimeSlot slot: slots) {
						System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymID());
						index++;
					}
					System.out.println("Please enter the slot number you want to book");
					int slotIndex = in.nextInt();
					if(slotIndex < index) {
						customerService.bookSlot(slots.get(slotIndex-1).getGymID(), slots.get(slotIndex-1).getSlotHour(), user.getUserID());
					}
					else {
						System.out.println("Unknown Slot!");
					}
					break;
				case 3:
					ArrayList<TimeSlot> bookedSlots = BookingServiceOperation.getInstance().viewBookings(user.getUserID());
					System.out.println("\n********************* Your Bookings ****************\n");
					System.out.println("Booking No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------");
					index = 1;
//					bookedSlots.forEach();
					for(TimeSlot slot: bookedSlots) {
						System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymID());
						index++;
					}
					System.out.println("\nPlease enter the booking number to be cancelled");
					int bookingIndex = in.nextInt();
					if(bookingIndex < index)
						customerService.cancelSlot(bookedSlots.get(bookingIndex-1).getGymID(), bookedSlots.get(bookingIndex-1).getSlotHour(), user.getUserID());
					else
						System.out.println("\033[1mNo such booking number exists!\033[0m");
					break;
				case 4:
					bookedSlots = BookingServiceOperation.getInstance().viewBookings(user.getUserID());
					System.out.println("\n********************* Your Bookings ****************\n");
					System.out.println("Booking No.\tTimings(24hrs)\t\tGymID\n------------------------------------------------------");
					index = 1;
					for(TimeSlot slot: bookedSlots) {
						System.out.println(index+"\t\t"+slot.getSlotHour()+":00-"+(slot.getSlotHour()+1)+":00"+"\t\t"+slot.getGymID());
						index++;
					}
					break;
				case 5:
					customerService.viewProfile(user).display();
					break;
				case 6:
					System.out.println("\033[1mYou have exited the customer menu\033[0m");
					break;
				default:
					System.out.println("\033[1mYou have selected invalid option please try again!!\\033[0m");
					break;
			}
		} while (menuOption != 6);
	}

}
