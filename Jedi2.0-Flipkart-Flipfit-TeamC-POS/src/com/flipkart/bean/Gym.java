package com.flipkart.bean;
/**
 * @author jyotishna
 * 
 **/
import com.flipkart.constants.Constants;

public class Gym {
	private int gymID;
	private String gymName;
	private int gymOwnerID;
	private String location;
	private int noOfSeats;
	private int approvalStatus = Constants.PENDING;

	public int getGymID() {
		return gymID;
	}

	public void setGymID(int gymID) {
		this.gymID = gymID;
	}

	public int getGymOwnerID() {
		return gymOwnerID;
	}

	public void setGymOwnerID(int gymOwnerID) {
		this.gymOwnerID = gymOwnerID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int isApproved) {
		this.approvalStatus = isApproved;
	}

	public String getGymName() {
		return gymName;
	}

	public void setGymName(String gymName) {
		this.gymName = gymName;
	}

}
