/**
 * 
 */
package com.lives.model;

import java.util.Date;

/**
 * @author yyypasserby
 *
 */
public class Message {

	private int actionId;
	private int userId;
	private int vid;
	private int type;
	private String heading;
	private String content;
	private String thumbnail;
	private String castTime;
	private String username;
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Message(String name, String heading, String thumbnail, String time, String status) {
		this.heading = heading;
		this.thumbnail = thumbnail;
	}
	

	public Message(int aid, int uid,int vid, int type,String heading, String content,String thumbnail, String time,String username) {
		this.actionId=aid;
		this.userId=uid;
		this.vid=vid;
		this.type=type;
		this.heading=heading;
		this.content =content;
		this.thumbnail = thumbnail;
		this.castTime=time;
		this.username=username;
	}
	
	
	/**
	 * @return the heading
	 */
	public String getHeading() {
		return heading;
	}
	/**
	 * @param heading the heading to set
	 */
	public void setHeading(String heading) {
		this.heading = heading;
	}
	/**
	 * @return the thumbnail
	 */
	public String getThumbnail() {
		return thumbnail;
	}
	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getActionId() {
		return actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCastTime() {
		return castTime;
	}

	public void setCastTime(String castTime) {
		this.castTime = castTime;
	}
}
