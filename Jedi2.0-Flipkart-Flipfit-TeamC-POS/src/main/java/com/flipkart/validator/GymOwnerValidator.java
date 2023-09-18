/**
 * 
 */
package com.flipkart.validator;

/**
 * @author rohit.r10
 */
public class GymOwnerValidator {
	public static boolean isPanCardValid(String panCard) {
		if(panCard.length() != 10) {
			System.out.println("Invalid PanCard Please try again!!");
		}
		return panCard.length() == 10;
	}
	
	public static boolean isAadharCardValid(String aadharCard) {
		if(aadharCard.length() != 14) {
			System.out.println("Invalid aadharCard Please try again!!");
		}
		return aadharCard.length() == 14;
 	}
	
	public static boolean isGstInValid(String gstIn) {
		if(gstIn.length() != 15) {
			System.out.println("Invalid gstIn Please try again!!");
		}
		return gstIn.length() == 15;
	}
}
