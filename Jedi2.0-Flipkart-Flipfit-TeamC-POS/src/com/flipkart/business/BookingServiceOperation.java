/**
 * jyotishna.baishya
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.bean.TimeSlot;
import com.flipkart.dao.BookingDAOImplementation;
import com.flipkart.dao.TimeSlotDAOImplementation;
/**
 * @author jyotishna
 * 
 **/
public class BookingServiceOperation implements BookingServiceInterface {

	private static BookingServiceInterface bookingServiceObj = null;

	public static synchronized BookingServiceInterface getInstance() {
		if (bookingServiceObj == null)
			bookingServiceObj = new BookingServiceOperation();

		return bookingServiceObj;
	}
	@Override
	public boolean addBooking(int slotID, int customerID) {
		// TODO Auto-generated method stub
		Booking booking = new Booking();
		booking.setSlotID(slotID);
		booking.setCustomerID(customerID);
		return BookingDAOImplementation.getInstance().insertBooking(booking);
	}

	@Override
	public boolean removeBooking(int slotID, int customerID) {
		// TODO Auto-generated method stub
		return BookingDAOImplementation.getInstance().removeBooking(slotID, customerID);
	}

	@Override
	public ArrayList<TimeSlot> viewBookings(int customerID) {
		// TODO Auto-generated method stub
		ArrayList<Booking> bookings = BookingDAOImplementation.getInstance().viewBookings(customerID);
		ArrayList<TimeSlot> slots = new ArrayList<TimeSlot>();
		
		for(Booking booking: bookings) {
			TimeSlot slot = TimeSlotDAOImplementation.getInstance().getSlotByID(booking.getSlotID());
			slots.add(slot);
		}
		return slots;
	}

}
