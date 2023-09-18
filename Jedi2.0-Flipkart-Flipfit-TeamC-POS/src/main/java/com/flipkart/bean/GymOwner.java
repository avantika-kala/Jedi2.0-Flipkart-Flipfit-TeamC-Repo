package com.flipkart.bean;
/**
 * @author rohit.r10
 */
import java.util.ArrayList;

import com.flipkart.constants.Constants;

public class GymOwner extends User {
	private String name;
	private String pinCode;
	private String address;
	private String aadharCard;
	private String panCard;
	private String gstIN;
	private int approvalStatus = Constants.PENDING;
	private ArrayList<Gym> gymList;

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getGstIN() {
		return gstIN;
	}

	public void setGstIN(String gstIN) {
		this.gstIN = gstIN;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public ArrayList<Gym> getGymList() {
		return gymList;
	}

	public void setGymList(ArrayList<Gym> gymList) {
		this.gymList = gymList;
	}

	public int getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(int status) {
		this.approvalStatus = status;
	}
	
	public void display() {
		System.out.println("~~~~~~~~~~~~~~GymOwner Profile~~~~~~~~~~~~~~");
		System.out.println("Username: "+this.getUserName());
		System.out.println("Name: "+this.getName());
		System.out.println("Address: "+this.getAddress());
		System.out.println("PIN Code: "+this.getPINCode());
		System.out.println("Aadhar Card: "+this.aadharCard);
		System.out.println("Pan Card: "+this.panCard);
		System.out.println("GSTIN: "+this.gstIN);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPINCode() {
		return pinCode;
	}

	public void setPINCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
