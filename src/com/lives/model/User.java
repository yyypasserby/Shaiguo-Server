package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private double hotRate;
	private int status;
	private int extraVideoId;
	
	//status
	//0 : online
	//1 : offline
	//2 : casting
	//3 : watching
	//extraVideoId : if is watching, then id is available
	public User(int id, String name, String email, int status) {
		this.userId = id;
		this.username = name;
		this.email = email;
		this.status = status;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	private String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the hotRate
	 */
	public double getHotRate() {
		return hotRate;
	}
	/**
	 * @param hotRate the hotRate to set
	 */
	public void setHotRate(double hotRate) {
		this.hotRate = hotRate;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the extraVideoId
	 */
	public int getExtraVideoId() {
		if(getStatus() == 3)
			return extraVideoId;
		return -1;
	}
	/**
	 * @param extraVideoId the extraVideoId to set
	 */
	public void setExtraVideoId(int extraVideoId) {
		if(this.status != 3) return;
		this.extraVideoId = extraVideoId;
	}
}
