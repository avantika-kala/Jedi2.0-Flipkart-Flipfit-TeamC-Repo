package com.flipkart.dao;

import java.util.ArrayList;

import com.flipkart.bean.Notification;
/**
 * @author avantika
 * 
 **/
public interface NotificationDAOInterface {
	
	/**
	 * Insert a new notification in the database
	 * @param notification
	 * @return Integer denoting the number of rows updated in the database
	 */
	public int insert(Notification notification);
	/**
	 * Fetch all the notifications related to a user
	 * @param userId
	 * @param userType
	 * @return List containing all the notifications related to a user
	 */
	public ArrayList<Notification> getNotifications(int userId, String userType);
}
