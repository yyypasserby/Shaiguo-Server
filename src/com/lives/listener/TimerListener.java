package com.lives.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerListener implements ServletContextListener{

	private Timer timer;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if(timer!=null)
			timer.cancel();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		timer = new Timer(true);
		timer.schedule(new TagUpdateTimer(), 0, 24*60*60*1000);
		timer.schedule(new CastUpdateTimer(), 0 , 2*60*60*1000);
	}

}
