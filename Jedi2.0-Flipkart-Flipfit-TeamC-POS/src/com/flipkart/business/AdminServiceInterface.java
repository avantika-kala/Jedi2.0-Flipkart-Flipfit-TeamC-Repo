/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;

/**
 * @author avantika
 */
public interface AdminServiceInterface {
	/**
	 * Gets List of gym owners waiting for approval
	 * @return ArrayList<GymOwner>
	 */
	public ArrayList<GymOwner> getPendingGymOwnerApprovals();

	/**
	 * Approves Gym as provided by gymId
	 * @param gymId
	 * @param status
	 * @return int
	 */
	public int handleGymRegistrationRequest(int gymId, int status);

	/**
	 * Approves all the Gyms waiting for approval
	 */
	public void approveAllGymRegistrationRequests();

	/**
	 * Gets List of gyms waiting for approval
	 * @return ArrayList
	 */
	public ArrayList<Gym> getPendingGymRegistrationRequests();

	/**
	 * Approves Gym Owner as provided by gymId
	 * @param gymOwnerId
	 * @param status
	 */
	public void handleGymOwnerRequest(int gymOwnerId, int status);

	/**
	 * Approves all gym owners
	 */
	public void approveAllGymOwners();
}
