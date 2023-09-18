/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymOwnerDAOImplementation;

/**
 * @author avantika.kala
 */
public class AdminServiceOperation implements AdminServiceInterface {

	private static AdminServiceInterface adminServiceObj = null;

	private AdminServiceOperation() {
	}

	public static synchronized AdminServiceInterface getInstance() {
		if (adminServiceObj == null)
			adminServiceObj = new AdminServiceOperation();

		return adminServiceObj;
	}

	@Override
	public ArrayList<GymOwner> getPendingGymOwnerRequests() {
		return GymOwnerDAOImplementation.getInstance().getPendingGymOwnerApprovals();

	}

	@Override
	public String handleGymOwnerRequest(int gymOwnerId, int status) {

		boolean gymIdExists = false;

		gymIdExists = getPendingGymOwnerRequests().stream().filter(owner -> owner.getUserID() == (gymOwnerId))
				.count() > 0;

		if (!gymIdExists) {
			return ("Gym Owner ID " + gymOwnerId + " could not be found!");
		}

		int flag = GymOwnerDAOImplementation.getInstance().handleGymOwnerRequest(gymOwnerId, status);

		if (flag > 0) {
			return "Gym Owner ID " + gymOwnerId + " updated!";
		} else {
			return "Gym Owner ID " + gymOwnerId + " could not be udpated!";
		}
	}

	@Override
	public int handleGymRegistrationRequest(int gymId, int status) {
		for (Gym gym : getPendingGymRegistrationRequests()) {
			if (gym.getGymID() == gymId) {
				int flag = GymDAOImplementation.getInstance().handleGymRequest(gymId, status);
				if (flag > 0) {
					System.out.println("Gym ID " + gymId + " updated!");
				} else {
					System.out.println("Gym ID " + gymId + " could not be updated!");
				}
				return flag;
			}
		}
		System.out.println("Gym ID " + gymId + " could not be found!");
		return 0;
	}

	@Override
	public ArrayList<Gym> getPendingGymRegistrationRequests() {
		return GymDAOImplementation.getInstance().getPendingGymRegistrationRequests();

	}

	@Override
	public String approveAllGymRegistrationRequests() {
		return GymDAOImplementation.getInstance().approveAllGymRegistrationRequests();

	}

	@Override
	public String approveAllGymOwners() {
		return GymOwnerDAOImplementation.getInstance().approveAllGymOwners();
	}

}
