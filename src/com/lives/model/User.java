package com.lives.model;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.annotation.XmlRootElement;

import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.utils.DBUserAPI;

@XmlRootElement
public class User {
	private int userId;
	private String username;
	private String password;
	private String email;
	private int attention;
	private int userRole;
	private int castTagId;

	private List<Integer> tagList = new ArrayList<>();
	private String tags;
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
	public User() {

	}

	public User(int id, String name, String email, int tags) {
		this.userId = id;
		this.userRole = 3;
		this.username = name;
		this.email = email;
		this.hotRate = 100;
		this.status = 3;
		this.extraVideoId = 0;
	}

	public User(int id, String name, String email, String tags, int hotRate,
            int role, int status, String extraVideo) {
		this.userId = id;
		this.userRole = role;
		this.username = name;
		this.email = email;
		this.hotRate = hotRate;
		this.status = status;
		this.tags = tags;
		this.getTagList().add(0);
		this.getTagList().add(1);
		if (status == 3)
			this.extraVideoId = 0;
		else
			this.extraVideoId = -1;
	}
	public String register() throws SQLException {
		boolean res=false;
		String match_pwd="((?=.*\\d)(?=.*[a-z]).{6,20})";
		Pattern p=Pattern.compile(match_pwd);
		Matcher m=p.matcher(password);
		res=m.matches();
		if(!res)
			return "PASSWORD_NOT_VALID";
		if ("USERNAME_IS_OK".compareTo(DBUserAPI.checkUsername(username)) == 0) {
			DBUserAPI.insertUser(username, password, email, null);
			return DBUserAPI.getUserId(username);
		}
		return "USERNAME_IS_USED";
	}

	public String verify() throws SQLException {
		boolean res=false;
		String match_name="^[a-z0-9_-]{3,15}$";
		String match_pwd="((?=.*\\d)(?=.*[a-z]).{6,20})";
		Pattern p=Pattern.compile(match_name);
		Matcher m=p.matcher(username);
		res=m.matches();
		if(!res)
			return "USERNAME_NOT_VALID";
		p=Pattern.compile(match_pwd);
		m=p.matcher(password);
		res=m.matches();
		if(!res)
			return "PASSWORD_NOT_VALID";

		return DBUserAPI.checkLogin(username, password);
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @param username
	 *            the username to set
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
	 * @param email
	 *            the email to set
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
	 * @param password
	 *            the password to set
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
	 * @param userId
	 *            the userId to set
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
	 * @param hotRate
	 *            the hotRate to set
	 */
	public void setHotRate(Integer hotRate) {
		this.hotRate = hotRate;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the extraVideoId
	 */
	public int getExtraVideoId() {
		if (getStatus() == 3)
			return extraVideoId;
		return -1;
	}

	/**
	 * @param extraVideoId
	 *            the extraVideoId to set
	 */
	public void setExtraVideoId(int extraVideoId) {
		if (this.status != 3)
			return;
		this.extraVideoId = extraVideoId;
	}

	/**
	 * @return the userRole
	 */
	public int getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole
	 *            the userRole to set
	 */
	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	/**
	 * @return the tagList
	 */
	public List<Integer> getTagList() {
		return tagList;
	}

	/**
	 * @param tagList
	 *            the tagList to set
	 */
	public void setTagList(List<Integer> tagList) {
		this.tagList = tagList;
	}

	/**
	 * @return the castTagId
	 */
	public int getCastTagId() {
		return castTagId;
	}

	/**
	 * @param castTagId the castTagId to set
	 */
	public void setCastTagId(int castTagId) {
		this.castTagId = castTagId;
	}

	/**
	 * @return the attention
	 */
	public int getAttention() {
		return attention;
	}

	/**
	 * @param attention the attention to set
	 */
	public void setAttention(int attention) {
		this.attention = attention;
	}
}
