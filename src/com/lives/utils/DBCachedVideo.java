package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;

public class DBCachedVideo {
	private String tablename;
	private ResultSet  resultSet;
	private PreparedStatement prepareState;
	
	public DBCachedVideo(){
		tablename="CachedVideo";
	}
	
	public boolean insertCachedVideo(String userId, String location, Duration duration) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doInsert = "insert " +tablename+ 
					" (userId, location, duration) values (' " +userId+
					" ',' " +location+
					" ',' " +duration.toString() +" ')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.execute();
		}finally{
			connection.close();
		}
	}
}
