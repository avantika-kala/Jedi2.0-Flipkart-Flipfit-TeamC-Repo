package com.flipkart.exception;
/**
 * @author rohit.r10
 */
public class SlotAlreadyBookedException extends Exception{
	public SlotAlreadyBookedException() {
		super("This slot is already booked!!");
	}
}
