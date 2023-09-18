/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.User;

/**
 * @author rohit.r10
 */
public interface UserDAOInterface {
	/**
	 * Register a new user
	 * @param user
	 * @return Integer denoting the number of rows updated in the database
	 */
	public int register(User user);

	/**
	 * Delete the user
	 * @param id
	 */

	public void delete(String id);

	/**
	 * Update user password in the database
	 * @param user
	 * @param newPassword
	 * @return Integer denoting the number of rows updated in the database
	 */

	public int updatePassword(User user, String newPassword);
	
	/**
	 * Find and login a particular user
	 * @param username
	 * @param password
	 * @return The logged in user or null if not found
	 */
	
	public User loginUser(String username, String password);
}
