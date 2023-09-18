package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.dao.GymDAOImplementation;
/**
 * @author jyotishna
 * 
 **/
public class GymServiceOperation implements GymServiceInterface {

	private static GymServiceInterface gymServiceObj = null;

	private GymServiceOperation() {
	}

	public static synchronized GymServiceInterface getInstance() {
		if (gymServiceObj == null)
			gymServiceObj = new GymServiceOperation();

		return gymServiceObj;
	}

	@Override
	public Gym viewGym(int gymID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Gym> viewGymList() {
		// TODO Auto-generated method stub
		return GymDAOImplementation.getInstance().getApprovedGymsList();
	}

}
