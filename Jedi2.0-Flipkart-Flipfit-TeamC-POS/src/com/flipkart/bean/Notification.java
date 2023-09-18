/**
 * 
 */
package com.flipkart.bean;

import java.util.Date;

/**
 * @author avantika
 */
public class Notification {
	String notifID;
	int userID;
	String userType;
	String content;
	Boolean isViewed = false;
	Date createdAt;
	
	public Notification() {
		
	}

	public Notification(int userID, String userType, String content, Boolean isViewed) {
		super();
		this.userID = userID;
		this.userType = userType;
		this.content = content;
		this.isViewed = isViewed;
	}

	public Boolean getIsViewed() {
		return isViewed;
	}

	public void setIsViewed(Boolean isViewed) {
		this.isViewed = isViewed;
	}

	public String getNotifID() {
		return notifID;
	}

	public void setNotifID(String notifID) {
		this.notifID = notifID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return createdAt;
	}

	public void setDate(Date date) {
		this.createdAt = date;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
