package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymOwner;
/**
 * @author avantika
 * 
 **/
public interface AdminDAOInterface {
	
	/**
	 * Approve gym owners
	 * 
	 * @return boolean
	 */
	public boolean approveGymOwner();
	
	/**
	 * Fetch all pending gym owners registrations
	 * @return List of pending gymowners
	 */
	
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	/**
	 * Approve a gym registration request
	 * @return boolean whether approved or not
	 */
	public boolean approveGymRegistrationRequest();
	
	/**
	 * Fetch all pending gym location registrations
	 * 
	 */
	
	public void getPendingGymLocationRegistrationRequests();
	
	/**
	 * Fetch all approved gym owners
	 */
	public void viewAllGymOwners();
}
