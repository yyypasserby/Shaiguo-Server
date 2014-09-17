package com.lives.listener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import com.lives.utils.DBRelationAPI;
import com.lives.utils.DBUserAPI;

public class RemainUpdateTimer extends TimerTask{

	private boolean isRunning = false;	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!isRunning){
			isRunning = true;
			List<Integer> list= new ArrayList<>();
			try {
				list = DBUserAPI.getAllUserId();
			for(int i=0;i<list.size();i++)
			{
				int id = list.get(i);
				DBUserAPI.updateUserRemains(id, 3);
			} 
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

}
