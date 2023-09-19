package com.flipkart.business;

/**
 * @author karan.k2
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.bean.Gym;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.TimeSlot;
import com.flipkart.bean.User;
import com.flipkart.dao.GymDAOImplementation;
import com.flipkart.dao.GymOwnerDAOImplementation;

public class GymOwnerServiceOperation implements GymOwnerServiceInterface {

	private static GymOwnerServiceInterface gymOwnerServiceObj = null;

	private GymOwnerServiceOperation() {
	}

	public static synchronized GymOwnerServiceInterface getInstance() {
		if (gymOwnerServiceObj == null)
			gymOwnerServiceObj = new GymOwnerServiceOperation();

		return gymOwnerServiceObj;
	}

	List<Gym> gymList = new ArrayList<Gym>();

	@Override
	public boolean addGymCentre(Gym newGym) {
		// TODO Auto-generated method stub
		boolean isAdded = GymDAOImplementation.getInstance().addGymCentre(newGym);
		if (isAdded) {
			gymList.add(newGym);
		}
		return isAdded;
	}

	@Override
	public ArrayList<Gym> getRegisteredGyms(int gymOwnerID) {
		// TODO Auto-generated method stub
		ArrayList<Gym> registeredGyms = GymDAOImplementation.getInstance().getRegisteredGymsForGymOwnerID(gymOwnerID);
		return registeredGyms;

	}
	
	@Override
	public void addGymSlot(int gymOwnerID, Scanner sc) {
		ArrayList<Gym> registeredGyms = getRegisteredGyms(gymOwnerID);
		System.out.println("Enter the GymID where to want to register slots");
		int gymID = sc.nextInt();
		Gym gym = registeredGyms.stream().filter(curr -> curr.getGymID() == gymID).findAny().orElse(null);

		
		
		if(gym != null) {
			System.out.println("Add the number of slots to be added");
			int numberOfSlots = sc.nextInt();
			TimeSlotOperation service = new TimeSlotOperation();
			for(int i=1; i<=numberOfSlots; i++) {
				System.out.println("\nEnter the start hour of slot in 24hrs format ("+i+"/"+numberOfSlots+")");
				int slotHour = sc.nextInt();
				TimeSlot slot = new TimeSlot();
				slot.setAvailableSeats(gym.getNoOfSeats());
				slot.setSlotHour(slotHour);
				slot.setGymID(gym.getGymID());
				boolean isAdded = service.addSlot(slot);
				if(isAdded) {
					System.out.println(i+"th Slot Added Successfully");
				}
			}
		}else {
			System.out.println("Gym not found");
		}
		
		System.out.println("\nExiting slot adding menu");
		
	}
	
	@Override
	public GymOwner getGymOwnerByUsernamePassword(User user) {
		return GymOwnerDAOImplementation.getInstance().getGymOwnerByUsernamePassword(user.getUserName(), user.getPassword());
	}

	@Override
	public GymOwner getGymOwnerById(int id) {
		return GymOwnerDAOImplementation.getInstance().getGymOwnerById(id);
		}
	
	public static void main(String args[]) {
//		ArrayList<Gym> registeredGyms = GymOwnerServiceOperation.getInstance().getRegisteredGyms(6);
//		System.out.println(registeredGyms.size());
//		for(Gym gym : registeredGyms) {
//			System.out.println(gym.getGymID());
		
//		}
//		GymOwner gymOwner = GymOwnerServiceOperation.getInstance().getGymOwnerById(9);
//		System.out.println(gymOwner.getPanCard());
	}

}