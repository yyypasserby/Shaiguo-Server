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

	static String tablename1="Video";
	static String tablename2="Cast";
	static String firstParam=tablename1+".id";
	static String secondParam=tablename2+".vId";
	
	static public int insertVideo(int tags,int userId, String location,String name) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		String thumbnail= DBTagAPI.getTagById(tags).getThumbnailBig();
		if(thumbnail==null)
			return -1;
		if(!DBUserAPI.checkId(userId)) return -1;
		if(!DBUserAPI.checkId(tags)) return -2;
		try{
			String doInsert = "insert " +tablename+ 
					" (tags, userId, isRecommend, location, name, hotRate, casttime,thumbnail,attention) values (" +tags+
					" , " +userId+
					" , " +0+  //isRecommend
					" ,'" +location+
					"','" +name+
					"', " +0+  //hotRate
					" ,'" +"0000-01-01 00:00:00"+
					"','" +thumbnail+
					"', " +0+
					" )";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int insertVideo(int tags,int userId,int isRecommend, String location,String name,int hotRate,String duration,String thumb,int attention) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		String thumbnail= DBTagAPI.getTagById(tags).getThumbnailBig();
		if(thumbnail==null)
			return -1;
		if(!DBUserAPI.checkId(userId)) return -1;
		if(!DBUserAPI.checkId(tags)) return -2;
		try{
			String doInsert = "insert " +tablename+ 
					" (tags, userId, isRecommend, location, name, hotRate, casttime,thumbnail,attention) values (" +tags+
					" , " +userId+
					" , " +isRecommend+  //isRecommend
					" ,'" +location+
					"','" +name+
					"', " +hotRate+  //hotRate
					" ,'" +duration+
					"','" +thumbnail+
					"', " +attention+
					" )";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	

	
	static public int updateTodayApply(int tags,int userId, String location,String livename) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{

			String doInsert = "update " +tablename+ " set tags=" +tags+ " , userId=" +userId+ 
					" ,location='" +location+ "', name='" +livename+ "' where location='" +location+ "'";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
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
			PreparedStatement prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}

	static public List<Live> searchVideoByName(String name) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Live> videolist = new ArrayList<Live>(); 
		String condition=tablename1+".name";
		try{
			String doSearch = "select * from " +tablename1+ " inner join "+tablename2+
					" where "+condition+" like '%" +name+ "%' and "+firstParam+"="+secondParam;
			System.out.println(doSearch);
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
	
	static public List<Live> searchVideoByTag(int tag) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Live> videolist = new ArrayList<Live>(); 
		String condition=tablename1+".tags";
		try{
			String doSearch =  "select * from " +tablename1+ " inner join "+tablename2+
					" where "+condition+"='"+tag+"' and "+firstParam+"="+secondParam;
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
	
	static public String searchPreName(String key) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		String condition=tablename1+".name";
		try{
			String doSearch = "select * from " +tablename1+ " inner join "+tablename2+
					" where "+condition+" like '%" +key+ "%' limit 0,1";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
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
			String doSearch =  "select * from " +tablename1+ " inner join "+tablename2+
					" where "+firstParam+"="+secondParam+" limit 0,5";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
			{	
				videolist.add(new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
						resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
						resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
			}
			return videolist;
		}finally{
			connection.close();
		}
	}
	
	static public Live getVideoById(int vid) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection(); 
		try{
			String doSearch = "select * from " +tablename+ " where id="+vid+" limit 0,1";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			if(resultSet.next())
			return (new Live(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
					resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6),
					resultSet.getInt(7),resultSet.getString(8),resultSet.getString(9),resultSet.getInt(10)));
			return (new Live());
		}finally{
			connection.close();
		}
	}
	
	static public boolean checkVid(int id) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select 1 from "+tablename+" where id="+id;
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return false;
			return true;
		}finally{
			connection.close();
		}
	}
	
	static public boolean checkLocation(String location) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select 1 from "+tablename+" where location='"+location+"'";
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return false;
			return true;
		}finally{
			connection.close();
		}
	}
}
