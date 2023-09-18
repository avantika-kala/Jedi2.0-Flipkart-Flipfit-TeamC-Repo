package com.flipkart.bean;

import java.time.LocalDate;
/**
 * @author jyotishna
 * 
 **/
public class TimeSlot {
	private int slotID;
	private int slotHour;
	private int gymID;
	private int availableSeats;
	private LocalDate day;

	public int getSlotID() {
		return slotID;
	}

	public void setSlotID(int slotID) {
		this.slotID = slotID;
	}

	public int getGymID() {
		return gymID;
	}

	public void setGymID(int gymID) {
		this.gymID = gymID;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDate getDay() {
		return day;
	}

	public void setDay(LocalDate day) {
		this.day = day;
	}

	public int getSlotHour() {
		return slotHour;
	}

	public void setSlotHour(int slotHour) {
		this.slotHour = slotHour;
	}
}
