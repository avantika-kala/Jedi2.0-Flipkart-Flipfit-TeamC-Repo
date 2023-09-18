package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.TimeSlot;
import com.flipkart.dao.TimeSlotDAOImplementation;
/**
 * @author jyotishna
 * 
 **/

public class TimeSlotOperation implements TimeSlotInterface {

	private static TimeSlotInterface timeSlotServiceObj = null;

	public static synchronized TimeSlotInterface getInstance() {
		if (timeSlotServiceObj == null)
			timeSlotServiceObj = new TimeSlotOperation();

		return timeSlotServiceObj;
	}

	@Override
	public TimeSlot findSlot(int slotHour, int gymID) {
		// TODO Auto-generated method stub
		TimeSlot availableSlot = TimeSlotDAOImplementation.getInstance().findSlot(slotHour, gymID);
		if(availableSlot.getAvailableSeats() > 0) return availableSlot;
		return null;
	}

	@Override
	public boolean addSlot(int slotHour, int gymID, int availableSeats) {
		// TODO Auto-generated method stub
		TimeSlot slot = new TimeSlot();
		
		slot.setSlotHour(slotHour);
		slot.setGymID(gymID);
		slot.setAvailableSeats(availableSeats);
		slot.setDay(java.time.LocalDate.now());
		
		boolean isAdded = TimeSlotDAOImplementation.getInstance().insertSlot(slot);
		return isAdded;
	}

	@Override
	public boolean updateSlot(int slotHour, int gymID, int changeInSeats) {
		// TODO Auto-generated method stub
		boolean isUpdated = TimeSlotDAOImplementation.getInstance().updateSlot(slotHour, gymID, changeInSeats);
		return isUpdated;
	}

	@Override
	public ArrayList<TimeSlot> getAllAvailableSlots() {
		// TODO Auto-generated method stub
		return TimeSlotDAOImplementation.getInstance().getAllAvailableSlots();
	}
	


}
