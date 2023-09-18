package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;

/**
 * @author jyotishna
 * 
 **/
public interface TimeSlotDAOInterface {
	/**
	 * Insert a new time slot int the database
	 * @param slot
	 * @return boolean whether the insertion was successfull or not
	 */
	public boolean insertSlot(TimeSlot slot);
	
	/**
	 * Find a particular slot
	 * @param slotHour
	 * @param gymID
	 * @return the found time slot
	 */
	public TimeSlot findSlot(int slotHour, int gymID);
	
	/**
	 * Update the time slot
	 * @param slotHour
	 * @param gymID
	 * @param changeInSeats
	 * @return boolean whether updation was successfull or not
	 */
	
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats);
	
	/**
	 * Fetch all the available slots from the database
	 * @return list of all the available slots from the database
	 */
	
	public ArrayList<TimeSlot> getAllAvailableSlots();
	
	/**
	 * Fetch a slot by its ID
	 * @param slotID
	 * @return the found time slot 
	 */
	
	public TimeSlot getSlotByID(int slotID);
}
