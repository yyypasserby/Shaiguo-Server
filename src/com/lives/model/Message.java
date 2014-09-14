/**
 * 
 */
package com.lives.model;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author yyypasserby
 *
 */
@XmlRootElement
public class Message {

	private int actionId;
	private int userId;
	private int vid;
	private int type;
	private String time;
	
	public Message() {}

	public Message(int aid, int uid,int vid, int type, String time) {
		this.actionId=aid;
		this.userId=uid;
		this.vid=vid;
		this.type=type;
		this.time=time;
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


	public String gettime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}
}
