package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;
/**
 * @author jyotishna
 * 
 **/
public interface TimeSlotInterface {
	
	/**
	 * Returns a slot 
	 * @param slotHour
	 * @param gymID
	 * @return TimeSlot
	 */
	public TimeSlot findSlot(int slotHour, int gymID);

	/**
	 * Add a new Slot
	 * @param slotHour
	 * @param gymID
	 * @param availableSeats
	 * @return boolean
	 */
	public boolean addSlot(int slotHour, int gymID, int availableSeats);

	/**
	 * Update an existing slot
	 * @param slotHour
	 * @param gymID
	 * @param changeInSeats
	 * @return boolean
	 */
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats);
	
	/**
	 * Gets all available slot
	 * @return ArrayList
	 */
	public ArrayList<TimeSlot> getAllAvailableSlots();
	
}
