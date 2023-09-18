/**
 * 
 */
package com.flipkart.business;



import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.UserDAOImplementation;

/**
 * @author rohit.r10
 */
public class UserServiceOperation implements UserServiceInterface {

	private static UserServiceInterface userServiceObj = null;

	private UserServiceOperation() {
	}

	public static synchronized UserServiceInterface getInstance() {
		if (userServiceObj == null)
			userServiceObj = new UserServiceOperation();

		return userServiceObj;
	}
	
	@Override
	public boolean registration(String username, String password, String role) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);
		return UserDAOImplementation.getInstance().register(user) != 0;
	}

	@Override
	public User login(String userName, String password) {
		User loggedInUser = UserDAOImplementation.getInstance().loginUser(userName, password);
		return loggedInUser;
	}

	public int updatePassword(User user, String newPassword) {
		return UserDAOImplementation.getInstance().updatePassword(user, newPassword);
	}

	@Override
	public boolean customerRegistration(Customer customer) {
		// TODO Auto-generated method stub
		return CustomerDAOImplementation.getInstance().register(customer);
	}

	@Override
	public boolean gymOwnerRegistration(GymOwner gymOwner) {
		// TODO Auto-generated method stub
		return GymOwnerDAOImplementation.getInstance().register(gymOwner);
	}
}
