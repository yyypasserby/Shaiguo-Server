package com.lives.model;

public class UserAction {

	private int actionId;
	private int userId;
	private int vid;
	private int type;
	
	public UserAction(){
		this.vid=0;
		this.type=0;
	}
	
	public UserAction(int actionId,int userId,int vid,int type){
		this.actionId = actionId;
		this.userId = userId;
		this.vid=vid;
		this.type=type;
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
	public int getvid() {
		return vid;
	}
	public void setvid(int vid) {
		this.vid = vid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
