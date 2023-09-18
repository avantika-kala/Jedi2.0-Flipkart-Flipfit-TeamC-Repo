/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Booking;

/**
 * @author jyotishna
 * 
 **/
public interface BookingDAOInterface {
	/**
	 * Insert booking into the database
	 * @param booking
	 * @return boolean value whether the insertion was successfull or not
	 */
	public boolean insertBooking(Booking booking);
	/**
	 * Remove the booking from the database
	 * @param slotID
	 * @param customerID
	 * @return boolean value whether the removal was successful or not
	 */
	public boolean removeBooking(int slotID, int customerID);
	/**
	 * Get a list of all of the bookings of a user
	 * @param customerID
	 * @return List containing all the bookings of a user
	 */
	public ArrayList<Booking> viewBookings(int customerID);
}
