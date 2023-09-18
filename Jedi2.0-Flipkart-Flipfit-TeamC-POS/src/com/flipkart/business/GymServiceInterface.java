package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
/**
 * @author jyotishna
 * 
 **/
public interface GymServiceInterface {

	/**
	 * Returns Gym details
	 * @param gymId
	 * @return Gym
	 */
	public Gym viewGym(int gymId);

	/**
	 * Returns list of gyms
	 * @return ArrayList
	 */
	public ArrayList<Gym> viewGymList();

}
