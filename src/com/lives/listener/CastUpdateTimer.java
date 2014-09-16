package com.lives.listener;

import java.sql.SQLException;
import java.util.TimerTask;

import com.lives.utils.DBCastAPI;

public class CastUpdateTimer extends TimerTask{
	private static boolean isRunning=false;
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!isRunning){
			isRunning =true;
//			try {
////				DBCastAPI.deleteCast();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			isRunning =false;
		}
	}
	
}
