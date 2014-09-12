package com.lives.model;

public class UserAction {

	private int actionId;
	private int userId;
	private int state;
	private int type;
	
	public UserAction(){
		this.state=0;
		this.type=0;
	}
	
	public UserAction(int actionId,int userId,int state,int type){
		this.actionId = actionId;
		this.userId = userId;
		this.state=state;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
