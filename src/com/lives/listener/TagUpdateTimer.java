package com.lives.listener;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimerTask;

import javax.servlet.ServletContext;

import com.lives.utils.DBTagAPI;
import com.lives.utils.DBUserAPI;

public class TagUpdateTimer extends TimerTask{

	private static boolean isRunning=false;
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(!isRunning){
			isRunning = true;
			try {
				Map<String,Integer> tagcount = new HashMap<>();
				List<List> taglist = DBUserAPI.getUserTags();
				String key;
				for(int i=0;i<taglist.size();i++)
					for(int j=0;j<taglist.get(i).size();j++){
						key=(String)taglist.get(i).get(j);
						if(key.isEmpty()||key=="") break;
						if(tagcount.containsKey(key))
							tagcount.replace(key, tagcount.get(key)+1);
						else tagcount.put(key, 0);
					}
				Iterator it = tagcount.entrySet().iterator();
				Integer thevalue;
				String thekey;
				while(it.hasNext()){
					Map.Entry entry = (Map.Entry) it.next();
					thekey = (String) entry.getKey();
					System.out.println(thekey);
					thevalue = (Integer) entry.getValue();
					DBTagAPI.updateTagAttention(Integer.parseInt(thekey), thevalue);
				}
				System.out.println("it's running");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isRunning=false;
		}
		else
			System.out.println("task not finished");
	}

}
