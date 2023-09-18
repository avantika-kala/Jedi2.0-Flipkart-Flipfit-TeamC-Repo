/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Booking;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * @author jyotishna
 * 
 **/
public class BookingDAOImplementation implements BookingDAOInterface {

	private static BookingDAOInterface bookingDaoObj = null;

	private BookingDAOImplementation() {
	}

	public static synchronized BookingDAOInterface getInstance() {
		if (bookingDaoObj == null)
			bookingDaoObj = new BookingDAOImplementation();

		return bookingDaoObj;
	}
	
	@Override
	public boolean insertBooking(Booking booking) {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getConnection();
		int rowsUpdated = 0;
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_BOOKING);
				preparedStatement.setInt(1, booking.getSlotID());
				preparedStatement.setInt(2, booking.getCustomerID());
				rowsUpdated = preparedStatement.executeUpdate();
				if (rowsUpdated > 0) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public boolean removeBooking(int slotID, int customerID) {
		// TODO Auto-generated method stub
		
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.DELETE_BOOKING);
				preparedStatement.setInt(1, slotID);
				preparedStatement.setInt(2, customerID);
				
				rowsUpdated = preparedStatement.executeUpdate();
				if(rowsUpdated > 0) return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public ArrayList<Booking> viewBookings(int customerID) {
		// TODO Auto-generated method stub
		
		ResultSet resultSet = null;
		ArrayList<Booking> bookingList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.SELECT_BOOKING);
				preparedStatement.setInt(1, customerID);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							Booking booking = new Booking();
							booking.setBookingID(resultSet.getInt(1));
							booking.setSlotID(resultSet.getInt(2));
							booking.setCustomerID(resultSet.getInt(3));
							bookingList.add(booking);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return bookingList;
	}
	
}

