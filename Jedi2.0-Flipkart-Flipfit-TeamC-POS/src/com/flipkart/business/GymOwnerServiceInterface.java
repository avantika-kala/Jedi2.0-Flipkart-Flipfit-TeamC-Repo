/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;

/**
 * @author karan.k2
 */
public interface GymOwnerServiceInterface {
	/**
	 * Adds a new Gym
	 * @param newGym
	 * @return
	 */
	public boolean addGymCentre(Gym newGym);
	/**
	 * Gets list of all the registered gyms
	 * @param gymOwnerID
	 * @return ArrayList
	 */
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID);
	/**
	 * Add a new gym slot
	 * @param gymOwnerID
	 * @param sc
	 */
	public void addGymSlot(int gymOwnerID, Scanner sc);
	/**
	 * Returns Gym Owner's Profile
	 * @param user
	 * @return GymOwner
	 */
	public GymOwner viewProfile(User user);
}
