package com.lives.model;

import java.util.Date;

public class Video {
	private int vid;
	private int tags;
	private int userId;
	private int isRecommend;
	private String location;
	private String name;
	private int hotRate;
	private Date duration;
	
	public Video(){
		
	}
	
	public Video(int vid,int tags,int userId,int isRecommend, String location,String name,int hotRate,Date duration){
		this.vid = vid;
		this.tags = tags;
		this.userId = userId;
		this.isRecommend = isRecommend;
		this.location = location;
		this.name = name;
		this.hotRate = hotRate;
		this.duration = duration;
	}
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getTags() {
		return tags;
	}
	public void setTags(int tags) {
		this.tags = tags;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHotRate() {
		return hotRate;
	}
	public void setHotRate(int hotRate) {
		this.hotRate = hotRate;
	}
	public Date getDuration() {
		return duration;
	}
	public void setDuration(Date duration) {
		this.duration = duration;
	}

}
