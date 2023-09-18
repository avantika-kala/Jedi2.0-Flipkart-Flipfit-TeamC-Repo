package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
/**
 * @author rohit.r10
 */
public interface UserServiceInterface {
	/**
	 * Registers a new customer
	 * @param customer
	 * @return boolean
	 */
	public boolean customerRegistration(Customer customer);
	
	/**
	 * Registers a new gym owner
	 * @param gymOwner
	 * @return boolean
	 */
	public boolean gymOwnerRegistration(GymOwner gymOwner);
	
	/**
	 * Registration Process
	 * @param username
	 * @param password
	 * @param role
	 * @return boolean
	 */
	public boolean registration(String username, String password, String role);

	/**
	 * Logs in a user
	 * @param userId
	 * @param password
	 * @return User
	 */
	public User login(String userId, String password);

	/**
	 * Update user password
	 * @param user
	 * @param newPassword
	 * @return int
	 */
	public int updatePassword(User user, String newPassword);
}
