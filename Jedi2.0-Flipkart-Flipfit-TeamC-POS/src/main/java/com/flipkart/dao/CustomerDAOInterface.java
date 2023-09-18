package com.flipkart.dao;

import com.flipkart.bean.Customer;
/**
 * @author rohit.r10
 */
public interface CustomerDAOInterface {

	/**
	 * Insert the customer into the database
	 * @param customer
	 * @return Integer denoting whether the insertion was successfull or not
	 */
	public int insert(Customer customer);
	
	/**
	 * Fetch the customer profile information from the database
	 * @param username
	 * @param password
	 * @return customer fetched from the database
	 */
	
	public Customer getUserByUsernamePassword(String username, String password);

	/**
	 * Fetch the customer profile information from the database
	 * @param username
	 * @param password
	 * @return customer fetched from the database
	 */
	
	public Customer getUserByUserId(int id);
	
	
	/**
	 * Register the customer
	 * @param customer
	 * @return boolean value whether the customer was registered or not
	 */
	
	public boolean register(Customer customer);
	
	/**
	 * Delete a customer
	 * @param id
	 */

	public void delete(String id);

	
	/**
	 * update a customer
	 * @param id
	 * @param newCustomer
	 */
	
	public void update(String id, Customer newCustomer);
}
