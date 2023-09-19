/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.constants.Constants;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * @author rohit.r10
 */
public class GymOwnerDAOImplementation implements GymOwnerDAOInterface {

	private static GymOwnerDAOInterface gymOwnerDaoObj = null;

	private GymOwnerDAOImplementation() {
	}

	public static synchronized GymOwnerDAOInterface getInstance() {
		if (gymOwnerDaoObj == null)
			gymOwnerDaoObj = new GymOwnerDAOImplementation();

		return gymOwnerDaoObj;
	}
	
	public boolean register(GymOwner gymowner) {
		UserDAOInterface userDAO = UserDAOImplementation.getInstance();
		if(userDAO.register(gymowner) > 0) {
			User user  = userDAO.loginUser(gymowner.getUserName(), gymowner.getPassword());
			gymowner.setUserID(user.getUserID());
			gymowner.setRole(Constants.ROLE_GYMOWNER);
			
			if(insert(gymowner) > 0) {
				System.out.println("GymOwner has been registered and sent for approval!!");
				return true;
			}else {
				return false;
			}
		}
		return false;
	}

	@Override
	public GymOwner getGymOwnerById(int id) {
		GymOwner gymOwner = new GymOwner();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.JOIN_GYM_OWNER_BY_ID);
				preparedStatement.setInt(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {
					try {
						while (resultSet.next()) {
							gymOwner = new GymOwner();
							gymOwner.setUserID(resultSet.getInt(1));
							gymOwner.setUserName(resultSet.getString(2));
							gymOwner.setAadharCard(resultSet.getString(3));
							gymOwner.setPanCard(resultSet.getString(4));
							gymOwner.setGstIN(resultSet.getString(5));
							gymOwner.setApprovalStatus(resultSet.getInt(6));
							gymOwner.setName(resultSet.getString(7));
							gymOwner.setAddress(resultSet.getString(8));
							gymOwner.setPINCode(resultSet.getString(9));
							gymOwner.setRole(Constants.ROLE_GYMOWNER);
						}
					} catch (SQLException e) {
						e.printStackTrace();resultSet = preparedStatement.executeQuery();
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
		return gymOwner;
	}
	
	public GymOwner getGymOwnerByUsernamePassword(String username, String password) {
		UserDAOInterface userDAO = UserDAOImplementation.getInstance();
		User loggedInUser = userDAO.loginUser(username, password);
		if(loggedInUser!=null){
			GymOwner gymOwner = new GymOwner();
			gymOwner.setUserID(loggedInUser.getUserID());
			gymOwner.setUserName(loggedInUser.getUserName());
			gymOwner.setPassword(loggedInUser.getPassword());
			Connection connection = DBConnection.getConnection();
			if (connection != null) {
				try {
					String selectQuery = SqlConstants.SELECT_GYM_OWNER + SqlConstants.WHERE_ID;
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
					preparedStatement.setInt(1,gymOwner.getUserID());
					ResultSet rs = preparedStatement.executeQuery();
					while(rs.next()){
						 //Retrieve by column name
						 rs.getInt("ID");
						 String aadharCard = rs.getString("aadharcard");
						 gymOwner.setAadharCard(aadharCard);
						 String panCard = rs.getString("pancard");
						 gymOwner.setPanCard(panCard);
						 String gstIn = rs.getString("gstin");
						 gymOwner.setGstIN(gstIn);
						 int isApproved = rs.getInt("isApproved");
						 gymOwner.setApprovalStatus(isApproved);
						 String name = rs.getString("name");
						 gymOwner.setName(name);
						 String address = rs.getString("address");
						 gymOwner.setAddress(address);
						 String pinCode = rs.getString("pincode");
						 gymOwner.setPINCode(pinCode);
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
			return gymOwner;
		}
		return null;
		
	}
	@Override
	public int insert(GymOwner gymOwner) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_GYM_OWNER);
				prepareStatement(preparedStatement, gymOwner);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch(SQLIntegrityConstraintViolationException ex) {
				System.out.println("Please enter valid details which are not being used in other accounts!!");
			}catch (SQLException e) {
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

	private void prepareStatement(PreparedStatement preparedStatement, GymOwner gymOwner) {
		try {
			preparedStatement.setInt(1, gymOwner.getUserID());
			preparedStatement.setString(2, gymOwner.getAadharCard());
			preparedStatement.setString(3, gymOwner.getPanCard());
			preparedStatement.setString(4, gymOwner.getGstIN());
			preparedStatement.setInt(5, 0);
			preparedStatement.setString(6,gymOwner.getName());
			preparedStatement.setString(7,gymOwner.getAddress());
			preparedStatement.setString(8,gymOwner.getPINCode());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, GymOwner newGymOwner) {
		// TODO Auto-generated method stub

	}

	public int handleGymOwnerRequest(int gymUserId, int status) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_OR_REJECT_GYM_OWNER + SqlConstants.WHERE_ID);
				preparedStatement.setInt(1, status);
				preparedStatement.setInt(2, gymUserId);
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
	
	public String approveAllGymOwners() {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.UPDATE_APPROVE_OR_REJECT_GYM_OWNER + SqlConstants.WHERE_PENDING_APPROVAL_FALSE);
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
		return (rowsUpdated + " gym owners approved");
	}

	public ArrayList<GymOwner> getPendingGymOwnerApprovals() {
		ResultSet resultSet = null;
		ArrayList<GymOwner> pendingGymOwnerList = new ArrayList<>();
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(SqlConstants.JOIN_GYM_OWNER_USER + SqlConstants.WHERE_PENDING_APPROVAL_FALSE);
				resultSet = preparedStatement.executeQuery();
				if (resultSet != null) {

					try {
						while (resultSet.next()) {
							GymOwner gymOwner = new GymOwner();
							gymOwner.setUserID(resultSet.getInt(1));
							gymOwner.setUserName(resultSet.getString(2));
							gymOwner.setAadharCard(resultSet.getString(3));
							gymOwner.setPanCard(resultSet.getString(4));
							gymOwner.setGstIN(resultSet.getString(5));
							gymOwner.setApprovalStatus(resultSet.getInt(6));
							gymOwner.setName(resultSet.getString(7));
							gymOwner.setAddress(resultSet.getString(8));
							gymOwner.setPINCode(resultSet.getString(9));
							gymOwner.setRole(Constants.ROLE_GYMOWNER);
							gymOwner.setPassword("xxxxxxxx");
							pendingGymOwnerList.add(gymOwner);
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
		return pendingGymOwnerList;
	}

}
