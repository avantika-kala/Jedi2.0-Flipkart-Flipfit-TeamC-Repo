/**
 * 
 */
package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.flipkart.bean.User;
import com.flipkart.constants.SqlConstants;
import com.flipkart.utils.DBConnection;

/**
 * @author rohit.r10
 */
public class UserDAOImplementation implements UserDAOInterface{

	private static UserDAOInterface userDaoObj = null;

	private UserDAOImplementation() {
	}

	public static synchronized UserDAOInterface getInstance() {
		if (userDaoObj == null)
			userDaoObj = new UserDAOImplementation();

		return userDaoObj;
	}

	@Override
	public int register(User user) {
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.INSERT_USER);
				prepareStatement(preparedStatement, user);
				rowsUpdated = preparedStatement.executeUpdate();
			} catch(SQLIntegrityConstraintViolationException e) {
				System.out.println("This username already exists!!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("# of DB Rows successfully updated: " + rowsUpdated);
		return rowsUpdated;

	}
	
	public User loginUser(String username, String password) {
		User user = null;
		Connection connection = DBConnection.getConnection();
		String generatedColumns[] = { "ID" };
		if (connection != null) {
			try {
				String selectQuery = SqlConstants.SELECT_USER + SqlConstants.WHERE_USERNAME + "'"+username+"'";
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery, generatedColumns);
				ResultSet rs = preparedStatement.executeQuery();
				while(rs.next()){
					 //Retrieve by column name
					 int userID  = rs.getInt("ID");
					 String usernameRecieved = rs.getString("username");
					 String passwordRecieved = rs.getString("password");
					 String roleRecieved = rs.getString("role");
					 
					 if(!password.equals(passwordRecieved)) {
						 System.out.println("Wrong username or password please try again!!");
					 }else {
						 user = new User();
						 user.setUserID(userID);
						 user.setPassword(passwordRecieved);
						 user.setRole(roleRecieved);
						 user.setUserName(usernameRecieved);
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
		return user;
	}
	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updatePassword(User user, String newPassword) {
		// TODO Auto-generated method stub
		int rowsUpdated = 0;
		Connection connection = DBConnection.getConnection();
		if (connection != null) {
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(SqlConstants.UPDATE_USER_PASSWORD);
				preparedStatement.setString(1,newPassword);
				preparedStatement.setInt(2,user.getUserID());
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

	private void prepareStatement(PreparedStatement preparedStatement, User user) {
		try {
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getRole());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Driver
	public static void main(String[] args) {
		UserDAOInterface userDAO = new UserDAOImplementation();
//		User user = new User();
//		user.setUserName("gymown2");
//		user.setPassword("pass");
//		user.setRole(Constants.ROLE_GYMOWNER);
		
//		userDAO.register(user);
		User loggedIn = userDAO.loginUser("gymown2","pass");
		System.out.println(loggedIn);
		
		
//		User user2 = new User();
//		user.setUserName("gymowner2");
//		user.setPassword("pass2");
//		user.setRole(Constants.ROLE_GYMOWNER);
	}


}
