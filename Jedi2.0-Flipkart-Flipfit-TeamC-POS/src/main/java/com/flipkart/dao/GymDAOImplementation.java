/**
 * jyotishna.baishya
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Gym;
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * @author rohit.r10
 */
public class GymDAOImplementation implements GymDAOInterface {

	private static GymDAOInterface gymDaoObj = null;

	private GymDAOImplementation() {
	}

	public static synchronized GymDAOInterface getInstance() {
		if (gymDaoObj == null)
			gymDaoObj = new GymDAOImplementation();

		return gymDaoObj;
	}

	@Override
	public boolean addGymCentre(Gym gym) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_GYM);
				prepareStatement(preparedStatement, gym);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
		return true;
	}


	@Override
	public ArrayList<Gym> getApprovedGymsList() {
		
		Connection connection = DBConnection.getConnection();
		ArrayList<Gym> registeredGyms = new ArrayList<Gym>();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.SELECT_GYM + SqlConstants.WHERE_APPROVAL_TRUE);
				ResultSet output = preparedStatement.executeQuery();
				while (output.next()) {
					int ID = output.getInt(1);
					String name = output.getString(2);
					int gymOwnerId = output.getInt(3);
					String location = output.getString(4);
					int numberOfSeats = output.getInt(5);
					int isApproved = output.getInt(6);
					if (isApproved == Constants.APPROVED) {
						Gym currGym = new Gym();
						currGym.setGymID(ID);
						currGym.setGymName(name);
						currGym.setGymOwnerID(gymOwnerId);
						currGym.setApprovalStatus(isApproved);
						currGym.setLocation(location);
						currGym.setNoOfSeats(numberOfSeats);
						registeredGyms.add(currGym);
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

		return registeredGyms;
	}
	
	@Override
	public ArrayList<Gym> getRegisteredGymsForGymOwnerID(int gymOwnerID) {
		
		Connection connection = DBConnection.getConnection();
		ArrayList<Gym> registeredGyms = new ArrayList<Gym>();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.WHERE_GYM_OWNER);
				preparedStatement.setInt(1, gymOwnerID);
				ResultSet output = preparedStatement.executeQuery();
				while (output.next()) {

					
					int ID = output.getInt(1);
					String gymName = output.getString(2); 
					String location = output.getString(4);
					int numberOfSeats = output.getInt(5);
					int isApproved = output.getInt(6);
					if (isApproved == Constants.APPROVED) {
						
						Gym currGym = new Gym();
						currGym.setGymID(ID);
						currGym.setGymName(gymName);
						currGym.setApprovalStatus(isApproved);
						currGym.setGymOwnerID(gymOwnerID);
						currGym.setLocation(location);
						currGym.setNoOfSeats(numberOfSeats);
						registeredGyms.add(currGym);
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

		return registeredGyms;
	}

	private void prepareStatement(PreparedStatement preparedStatement, Gym gym) {
		try {
			preparedStatement.setString(1, gym.getGymName());
			preparedStatement.setInt(2, gym.getGymOwnerID());
			preparedStatement.setString(3, gym.getLocation());
			preparedStatement.setInt(4, gym.getNoOfSeats());
			preparedStatement.setInt(5, gym.getApprovalStatus());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<Gym> getPendingGymRegistrationRequests() {
		ResultSet resultSet = null;
		ArrayList<Gym> pendingGymList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.SELECT_GYM + SqlConstants.WHERE_PENDING_APPROVAL_FALSE);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							Gym gym = new Gym();
							gym.setGymID(resultSet.getInt(1));
							gym.setGymName(resultSet.getString(2));
							gym.setGymOwnerID(resultSet.getInt(3));
							gym.setLocation(resultSet.getString(4));
							gym.setNoOfSeats(resultSet.getInt(5));
							pendingGymList.add(gym);
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
		return pendingGymList;
	}

	public int handleGymRequest(int gymId, int status) {

		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_GYM + SqlConstants.WHERE_ID);
				preparedStatement.setInt(1, status);
				preparedStatement.setInt(2, gymId);
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
	


	@Override
	public void approveAllGymRegistrationRequests() {

		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_GYM + SqlConstants.WHERE_PENDING_APPROVAL_FALSE);
				preparedStatement.setInt(1, Constants.APPROVED);
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
		if(rowsUpdated > 0) {
			System.out.println("All gyms approved!");
		} else {
			System.out.println("All gyms could not be approved!");
		}


	}

	@Override
	public Gym getGym(int gymID) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getConnection();
		Gym gym = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.WHERE_ID);
			preparedStatement.setInt(1, gymID);
			System.out.println(preparedStatement);
			ResultSet output = preparedStatement.executeQuery();
			gym = new Gym();
			while (output.next()) {
				gym.setGymID(output.getInt(1));
				gym.setGymOwnerID(output.getInt(2));
				gym.setGymName(output.getString(3));
				gym.setLocation(output.getString(4));
				gym.setNoOfSeats(output.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gym;
	}

}
