/**
 * 
 */
package com.flipkart.business;

import java.util.ArrayList;

import com.flipkart.bean.Notification;
import com.flipkart.bean.User;
import com.flipkart.constants.Constants;
import com.flipkart.dao.NotificationDAOImplementation;

/**
 * @author avantika
 */
public class NotificationServiceOperation implements NotificationServiceInterface {

	private static NotificationServiceInterface notificationServiceObj = null;

	private NotificationServiceOperation() {
	}

	public static synchronized NotificationServiceInterface getInstance() {
		if (notificationServiceObj == null)
			notificationServiceObj = new NotificationServiceOperation();

		return notificationServiceObj;
	}

	@Override
	public void addNotification(Notification notification) {
		NotificationDAOImplementation.getInstance().insert(notification);

	}

	@Override
	public ArrayList<Notification> viewMyNotifications(int userId, String userType) {
		return NotificationDAOImplementation.getInstance().getNotificationsByIDAndType(userId, userType);
	}
	
	public static void main(String args[]) {
		NotificationDAOImplementation.getInstance().getNotificationsByIDAndType(9, Constants.ROLE_GYMOWNER);
	}

}
