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

import com.lives.model.Live;

public class DBVideoAPI {
	private static String tablename="Video";
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	private static SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss");
	
	static public int insertVideo(int tags,int userId, String location,String name,Date duration) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doInsert = "insert " +tablename+ 
					" (tags, userId, isRecommend, location, name, hotRate, duration) values (" +tags+
					" , " +userId+
					" , " +0+  //isRecommend
					" ,'" +location+
					"','" +name+
					"', " +0+  //hotRate
					" ,'" +sdf.format(duration)+
					"')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int insertVideo(int tags,int userId,int isRecommend, String location,String name,int hotRate,Date duration) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doInsert = "insert " +tablename+ 
					" (tags, userId, isRecommend, location, name, hotRate, duration) values (" +tags+
					" , " +userId+
					" , " +isRecommend+  //isRecommend
					" ,'" +location+
					"','" +name+
					"', " +hotRate+  //hotRate
					" ,'" +sdf.format(duration)+
					"')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int updateVideo(int tags,int userId,int isRecommend, String location,String name,int hotRate,Date duration) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doInsert = "update " +tablename+ 
					" (tags, userId, isRecommend, location, name, hotRate, duration) values (" +tags+
					" , " +userId+
					" , " +isRecommend+  //isRecommend
					" ,'" +location+
					"','" +name+
					"', " +hotRate+  //hotRate
					" ,'" +sdf.format(duration)+
					"')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int deleteVideo(int videoId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+
					" where id= "  +videoId;
			prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}

	static public List<Live> searchVideoByName(String name) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Live> videolist = new ArrayList<Live>(); 
		try{
			String doSearch = "select * from " +tablename+ 
					" where name like '%" +name+ "%'";
			prepareState = connection.prepareStatement(doSearch);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
	
	static public List<Live> searchVideoByTag(int tag) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Live> videolist = new ArrayList<Live>(); 
		try{
			String doSearch = "select * from " +tablename+ 
					" where tags = " +tag;
			prepareState = connection.prepareStatement(doSearch);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
	
	static public String searchPreName(String key) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doSearch = "select name from " +tablename+ 
					" where name like '%" +key+ "%' limit 0,1";
			prepareState = connection.prepareStatement(doSearch);
			resultSet = prepareState.executeQuery();
			if(resultSet.next())
				return resultSet.getString(1);
			return new String();
		}finally{
			connection.close();
		}
	}
	
	static public List<Live> sortVideo() throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Live> videolist = new ArrayList<Live>(); 
		try{
			String doSearch = "select * from " +tablename+ " order by hotRate desc limit 0,5";
			prepareState = connection.prepareStatement(doSearch);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
}
