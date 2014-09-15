package com.lives.listener;

import java.util.TimerTask;

public class CastUpdateTimer extends TimerTask{
	private static boolean isRunning=false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!isRunning){
			isRunning =true;
			
		}
	}
	
}
