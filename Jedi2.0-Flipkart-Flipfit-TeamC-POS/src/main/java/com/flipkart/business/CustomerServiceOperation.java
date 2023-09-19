package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Customer;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.bean.TimeSlot;
/**
 * @author karan.k2
 **/
public class CustomerServiceOperation implements CustomerServiceInterface {

	private static CustomerServiceInterface customerServiceObj = null;

	private CustomerServiceOperation() {
	}

	public static synchronized CustomerServiceInterface getInstance() {
		if (customerServiceObj == null)
			customerServiceObj = new CustomerServiceOperation();

		return customerServiceObj;
	}
	@Override
	public Customer getProfile(User user) {
		return CustomerDAOImplementation.getInstance().getUserByUsernamePassword(user.getUserName(), user.getPassword());
	}
	@Override
	public Customer getProfilebyID(int userId) {
		return CustomerDAOImplementation.getInstance().getUserByUserId(userId);
	}
	@Override
	public boolean bookSlot(int gymID, int slotHour, int customerID) {
		// TODO Auto-generated method stub
		TimeSlot slot = TimeSlotOperation.getInstance().findSlot(slotHour, gymID);
		if(slot!=null) {
			if(!(BookingServiceOperation.getInstance().removeBooking(slot.getSlotID(), customerID))) {
				TimeSlotOperation.getInstance().updateSlot(slotHour, gymID, -1);
			}
			BookingServiceOperation.getInstance().addBooking(slot.getSlotID(), customerID);
			System.out.println("\033[1mYou have succesfully booked your slot.\033[0m");
			return true;
		}
		System.out.println("\033[1mSlot Unavailable!\033[0m");
		return false;
	}

	@Override
	public boolean cancelSlot(int gymID, int slotHour, int customerID) {
		// TODO Auto-generated method stub
		TimeSlot slot = TimeSlotOperation.getInstance().findSlot(slotHour, gymID);
		if(slot!=null) {
			if(BookingServiceOperation.getInstance().removeBooking(slot.getSlotID(), customerID)) {
				TimeSlotOperation.getInstance().updateSlot(slotHour, gymID, 1);
				System.out.println("\033[1mYou have succesfully cancelled your booking.\033[0m");
				return true;
			}
			else {
				System.out.println("\033[1mBooking not found.\033[0m");
				return false;
			}
		}
		return false;
	}
	@Override
	public String cancelSlotByID(int slotID,int userID) {
		// TODO Auto-generated method stub
		TimeSlot slot = TimeSlotOperation.getInstance().findSlotByID(slotID);
		if(slot!=null) {
			if(BookingServiceOperation.getInstance().removeBooking(slot.getSlotID(), userID)) {
				TimeSlotOperation.getInstance().updateSlot(slot.getSlotHour(), slot.getGymID(), 1);
				System.out.println("\033[1mYou have succesfully cancelled your booking.\033[0m");
				return "You have succesfully cancelled your booking.";
			}
			else {
				System.out.println("\033[1mBooking not found.\033[0m");
				return "Booking not found.";
			}
		}
		return "Booking not found";
	}

}
