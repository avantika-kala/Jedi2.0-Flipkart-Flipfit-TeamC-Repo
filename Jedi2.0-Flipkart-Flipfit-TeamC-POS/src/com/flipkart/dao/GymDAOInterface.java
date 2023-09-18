/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Gym;

/**
 * @author rohit.r10
 */
public interface GymDAOInterface {
	/**
	 * Add a gym centre
	 * @param gym
	 * @return boolean whether the addition was successfull or not
	 */
	public boolean addGymCentre(Gym gym);
	
	/**
	 * Fetch all the registered gyms from the database
	 * @return List of all the registered gyms
	 */
	
	public ArrayList<Gym> getApprovedGymsList();

	/**
	 * Fetch all the registered gyms of a particular GymOwner
	 * @param gymOwnerID
	 * @return List of all the registered gyms of the GymOwner
	 */
	
	public ArrayList<Gym> getRegisteredGymsForGymOwnerID(int gymOwnerID);

	/**
	 * Fetch a particular gym from the database
	 * @param gymID
	 * @return the found gym
	 */
	
	public Gym getGym(int gymID);

	/**
	 * Approve all the pending gym registration requests
	 */
	
	public void approveAllGymRegistrationRequests();
	
	/**
	 * Handle the incoming gym request , whether to approve or reject
	 * @param gymId
	 * @param status
	 * @return Integer denoting the number of rows updated in the database
	 */

	public int handleGymRequest(int gymId, int status);

	/**
	 * Fetch all the peding gym requests from the database
	 * @return list of all the pending requests from the database
	 */
	
	public ArrayList<Gym> getPendingGymRegistrationRequests();
}
