package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.lives.model.CachedVideo;

public class DBCachedVideoAPI {
	private String tablename;
	private ResultSet  resultSet;
	private PreparedStatement prepareState;
	
	public DBCachedVideoAPI(){
		tablename="CachedVideo";
	}
	
	public boolean insertCachedVideo(int userId, String location, String duration,String name) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String time = "24:00:00";
			if(duration.length()>8)
				return false;
			else if(time.compareTo(duration)<0)
				return false;
			String doInsert = "insert " +tablename+ 
					" (userId, location, duration,cachedname) values ('" +userId+
					"','" +location+
					"','" +duration+
					"','" +name+ "')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.execute();
		}finally{
			connection.close();
		}
	}
	
	public boolean deleteCachedVideo(int userId, String location) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+
					" where userId= "  +userId+
					" and location='" +location+ "'";
			prepareState = connection.prepareStatement(doDelete);
			return prepareState.execute();
		}finally{
			connection.close();
		}
	}

	public List<CachedVideo> searchCachedVideoByName(String cachedname) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<CachedVideo> cachedlist = new ArrayList<CachedVideo>(); 
		try{
			String doSearch = "select * from " +tablename+ 
					" where cachedname like '%" +cachedname+ "%'";
			prepareState = connection.prepareStatement(doSearch);
			resultSet = prepareState.executeQuery();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Date date;
			while(resultSet.next())
			{	date = sdf.parse(resultSet.getString(4));
				cachedlist.add(new CachedVideo(Integer.parseInt(resultSet.getString(1)),
						Integer.parseInt(resultSet.getString(2)),resultSet.getString(3),
						resultSet.getString(5),date.getTime()));
			}
			return cachedlist;
		}finally{
			connection.close();
		}
	}
}
