package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.GymOwner;
/**
 * @author jyotishna
 * 
 **/
public interface GymOwnerDAOInterface {
	/**
	 * Insert gym owner into the database
	 * @param gymOwner
	 * @return Integer value denoting the number of rows updated
	 */
	int insert(GymOwner gymOwner);
	
	/**
	 * Fetch the profile information from the database
	 * @param username
	 * @param password
	 * @return the profile information found in the database
	 */
	
	GymOwner getGymOwnerByUsernamePassword(String username, String password);
	
	/**
	 * Fetch the profile information from the database
	 * @param username
	 * @param password
	 * @return the profile information found in the database
	 */
	
	GymOwner getGymOwnerById(int id);

	
	/**
	 * Register a new gym owner
	 * @param gymowner
	 * @return boolean whether the registration was successfull or not
	 */
	
	boolean register(GymOwner gymowner);
	
	/**
	 * Delete a gym owner
	 * @param id
	 */
	
	void delete(String id);
	
	/**
	 * Update the gymOwner
	 * @param id
	 * @param newGymOwner
	 */
	
	void update(String id, GymOwner newGymOwner);
	
	/**
	 * Handle the Gym owner approval request , whether to approve or reject
	 * @param gymOwnerId
	 * @param status
	 * @return Integer denoting the number of rows updated in the database
	 */
	
	int handleGymOwnerRequest(int gymOwnerId, int status);
	
	/**
	 * Fetch all the pending approval requests of the gym owners from the database
	 * @return List of all the pending approval requests of the gym owners from the database
	 */
	
	ArrayList<GymOwner> getPendingGymOwnerApprovals();
	
	/**
	 * Approve all the pending gym owners requests in the database
	 */
	
	String approveAllGymOwners();
}
