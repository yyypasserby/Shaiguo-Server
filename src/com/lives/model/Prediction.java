package com.lives.model;

import java.util.Date;

public class Prediction {

	private int preId;
	private int actionId;
	private String heading;
	private String content;
	private String thumbnail;
	private String sendtime;
	private String casttime;
	

	public Prediction(){}
	

	public Prediction(int predictionId,int actionId,String heading,String content,String thumbnail,String sendtime,String casttime){
		this.preId = predictionId;
		this.actionId = actionId;
		this.heading = heading;
		this.content = content;
		this.thumbnail = thumbnail;
		this.sendtime = sendtime;
		this.casttime=casttime;
	}
	
	

	public String getCasttime() {
		return casttime;
	}


	public void setCasttime(String casttime) {
		this.casttime = casttime;
	}


	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	public String getSendtime() {
		return sendtime;
	}
	public int getPreId() {
		return preId;
	}
	public void setPreId(int preId) {
		this.preId = preId;
	}
	public int getActionId() {
		return actionId;
	}
	public void setActionId(int actionId) {
		this.actionId = actionId;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
}
