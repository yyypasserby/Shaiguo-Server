package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.lives.model.CachedVideo;

public class DBCachedVideoAPI {
	private static String tablename="CachedVideo";;

	static public int insertCachedVideo(int userId, String location,String duration,String name) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doInsert = "insert " +tablename+ 
					" (userId, location, duration,cachedname) values ('" +userId+
					"','" +location+
					"','" +duration+
					"','" +name+ "')";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int deleteCachedVideo(int userId, String location) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+
					" where userId= "  +userId+
					" and location='" +location+ "'";
			PreparedStatement prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int deleteCachedVideo(int cachedId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+
					" where id= "  +cachedId;
			PreparedStatement prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}


	static public List<CachedVideo> searchCachedVideoByName(String cachedname) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<CachedVideo> cachedlist = new ArrayList<CachedVideo>(); 
		try{
			String doSearch = "select * from " +tablename+ 
					" where cachedname like '%" +cachedname+ "%'";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			 ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				cachedlist.add(new CachedVideo(resultSet.getInt(1),
						resultSet.getInt(2),resultSet.getString(3),resultSet.getString(4),
						resultSet.getString(5)));
			}
			return cachedlist;
		}finally{
			connection.close();
		}
	}
	
	static public String searchPreName(String key) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doSearch = "select cachedname from " +tablename+ 
					" where cachedname like '%" +key+ "%' limit 0,1";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			 ResultSet resultSet = prepareState.executeQuery();
			if(resultSet.next())
				return resultSet.getString(1);
			return new String();
		}finally{
			connection.close();
		}
	}
	
}
