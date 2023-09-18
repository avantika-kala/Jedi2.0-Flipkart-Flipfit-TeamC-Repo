/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Notification;
import com.flipkart.bean.User;

/**
 * @author avantika
 */
public interface NotificationServiceInterface {

	/**
	 * Adds notification
	 * @param notification
	 */
	public void addNotification(Notification notification);

	/**
	 * Reutns all the notifications for a user
	 * @param user
	 * @param userType
	 * @return ArrayList
	 */
	ArrayList<Notification> viewMyNotifications(User user, String userType);
}
