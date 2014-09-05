/**
 * 
 */
package com.lives.model;

/**
 * @author yyypasserby
 *
 */
public class Message {
	private String username;
	private String heading;
	private String thumbnail;
	private String castTime;
	private String status;
	
	public Message(String name, String heading, String thumbnail, String time, String status) {
		this.username = name;
		this.heading = heading;
		this.thumbnail = thumbnail;
		this.castTime = time;
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
	/**
	 * @return the castTime
	 */
	public String getCastTime() {
		return castTime;
	}
	/**
	 * @param castTime the castTime to set
	 */
	public void setCastTime(String castTime) {
		this.castTime = castTime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
