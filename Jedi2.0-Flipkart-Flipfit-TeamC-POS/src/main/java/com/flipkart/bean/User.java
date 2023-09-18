/**
 * @author jyotishna.baishya
 */
package com.flipkart.bean;

/**
 * @author rohit.r10
 */
public class User {
	private int userID;
	private String userName;
	private String password;
	private String role;

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
