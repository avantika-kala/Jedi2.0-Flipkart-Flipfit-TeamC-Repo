/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Notification;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * @author avantika
 */
public class NotificationDAOImplementation implements NotificationDAOInterface {

	private static NotificationDAOInterface notificationDaoObj = null;

	private NotificationDAOImplementation() {
	}

	public static synchronized NotificationDAOInterface getInstance() {
		if (notificationDaoObj == null)
			notificationDaoObj = new NotificationDAOImplementation();

		return notificationDaoObj;
	}

	@Override
	public int insert(Notification notification) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_NOTIFICATION);
				prepareStatement(preparedStatement, notification);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rowsUpdated;
	}

	private void prepareStatement(PreparedStatement preparedStatement, Notification notification) {
		try {
			preparedStatement.setInt(1, notification.getUserID());
			preparedStatement.setString(2, notification.getUserType());
			preparedStatement.setString(3, notification.getContent());
			preparedStatement.setBoolean(4, false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Notification> getNotifications(int userId, String userType) {
		Connection connection = DBConnection.getConnection();
		ArrayList<Notification> notificationList = new ArrayList<Notification>();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.SELECT_NOTIFICATION + SqlConstants.WHERE_NOT_VIEWED_NOTIFICATION);
				preparedStatement.setInt(1, userId);
				preparedStatement.setString(2, userType);
				ResultSet output = preparedStatement.executeQuery();
				while (output.next()) {
					Notification notification = new Notification();
					notification.setUserID(userId);
					notification.setUserType(userType);
					notification.setContent(output.getString(4));
					notificationList.add(notification);
				}
				//Update the notifications after they are displayed once
				preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_NOTIFICATION + SqlConstants.WHERE_NOT_VIEWED_NOTIFICATION);
				preparedStatement.setInt(1, userId);
				preparedStatement.setString(2, userType);
				preparedStatement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return notificationList;

	}

}
