/**
 * jyotishna.baishya
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.bean.TimeSlot;

/**
 * @author jyotishna
 * 
 **/
public interface BookingServiceInterface {
	/**
	 * Adds a booking for the customer
	 * @param slotID
	 * @param customerID
	 * @return boolean
	 */
	public boolean addBooking(int slotID, int customerID);
	/**
	 * Removes a booking for the customer
	 * @param slotID
	 * @param customerID
	 * @return boolean
	 */
	public boolean removeBooking(int slotID, int customerID);
	/**
	 * Returns all the bookings done by the customer
	 * @param customerID
	 * @return ArrayList
	 */
	public ArrayList<TimeSlot> viewBookings(int customerID);
}
