package com.flipkart.exception;
/**
 * @author rohit.r10
 * 
 **/
public class LocationProofdAlreadyInUseException extends Exception{
	public LocationProofdAlreadyInUseException() {
		// TODO Auto-generated constructor stub
		super("Location proof is already being used in other accounts!!");
	}
}
