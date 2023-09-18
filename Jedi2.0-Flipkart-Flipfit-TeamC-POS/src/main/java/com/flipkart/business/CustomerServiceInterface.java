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
	public boolean bookSlot(int gymID, int slotHour, int customerID);

	/**
	 * Cancels a slot for the customer
	 * @param gymID
	 * @param slotHour
	 * @param customerID
	 * @return boolean
	 */
	public boolean cancelSlot(int gymID, int slotHour, int customerID);
}
