package com.lives.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private int userRole;
	private double hotRate;
	private int status;
	private int extraVideoId;
	
	//userRole
	//0 : all
	//1 : admin
	//2 : room-admin
	//3 : user
	
	//status
	//0 : online
	//1 : offline
	//2 : casting
	//3 : watching
	//extraVideoId : if is watching, then id is available
	public User() {}
	
	public User(int id, String name, String email, int status) {
		this.userId = id;
		this.userRole = 3;
		this.username = name;
		this.email = email;
		this.hotRate = 100;
		this.status = status;
		if(status == 3)
			this.extraVideoId = 0;
	}
	
	public String verify() {
		if(this.username == null)
			return "USERNAME_NOT_VALID";
		if(this.password == null)
			return "PASSWORD_NOT_VALID";
		System.out.println(this.username);
		System.out.println(this.password);
		
		if("yyypasserby".compareTo(username) == 0 && "123456".compareTo(password) == 0) {
			return "success";
		}
		return "USERNAME_PASSWORD_NOT_MATCHED";
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
	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}
}
