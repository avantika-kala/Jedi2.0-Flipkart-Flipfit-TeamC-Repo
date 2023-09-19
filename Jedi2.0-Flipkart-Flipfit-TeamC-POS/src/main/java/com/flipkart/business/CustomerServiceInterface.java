/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.bean.Customer;
import com.flipkart.bean.User;

/**
 * @author karan.k2
 */
public interface CustomerServiceInterface {
	
	/**
	 * Gets the user profile
	 * @param user
	 * @return Customer
	 */
	public Customer getProfile(User user);
	
	/**
	 * Books a slot for the customer
	 * @param gymID
	 * @param slotHour
	 * @param customerID
	 * @return boolean
	 */
	public String bookSlot(int gymID, int slotHour, int customerID);

	/**
	 * Cancels a slot for the customer
	 * @param gymID
	 * @param slotHour
	 * @param customerID
	 * @return boolean
	 */
	public boolean cancelSlot(int gymID, int slotHour, int customerID);
	
	/**
	 * returns customer by using userId
	 * @param userId
	 * @return Customer
	 */
	public Customer getProfilebyID(int userId);
	/**
	 * cancels Booking
	 * @param slotID
	 * @param userID
	 * @return Boolean
	 */
	public String cancelSlotByID(int slotID, int userID);
}
