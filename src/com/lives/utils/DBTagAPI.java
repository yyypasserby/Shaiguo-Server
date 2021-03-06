package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.lives.model.Tag;

public class DBTagAPI {

	private static String tablename= "Tag";
	
	
	static public int insertTag(String tagName,String thumbnailSmall,String thumbnailBig) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if(getTagByName(tagName)!=null) return -1;
			String doInsert = "insert into " +tablename+ " (tagName,tagAttention,tagPathBig,tagPathSmall) values ('" 
					+tagName+        "',0,'"
					+thumbnailSmall+ "','"
					+thumbnailBig+   "') ";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int insertTag(String tagName, int tagAttention,int live,String thumbnailSmall,String thumbnailBig) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if(getTagByName(tagName)!=null) return -1;
			String doInsert = "insert into " +tablename+ " (tagName,tagAttention,liveNumber,tagPathBig,tagPathSmall) values ('" 
					+tagName+      "', " 
					+tagAttention+ " , "
					+live+		   " ,'"
					+thumbnailBig+   "','"
					+thumbnailSmall+ "') ";
			PreparedStatement prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int  deleteTag(int tagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+ " where id=" +tagId;
			PreparedStatement prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
//			return prepareState.execute();
		}finally{
			connection.close();
		}
	}
	
	static public int updateTagAttention(int tagId, int tagAttention) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "update " +tablename+ " set tagAttention=" +tagAttention+ " where id=" +tagId;
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	

	static public int updateTagLiveNumber(int tagId, int liveNumber) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "update " +tablename+ " set liveNumber=" +liveNumber+ " where id=" +tagId;
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public Tag getTagById(int tagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "select * from " +tablename+ " where id=" +tagId;
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			ResultSet resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return new Tag();
			return new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(7), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
		}finally{
			connection.close();
		}
	}
	
	static public String searchPreName(String key) throws NumberFormatException, SQLException, ParseException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doSearch = "select tagName from " +tablename+ 
					" where tagName like '%" +key+ "%'";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			if(resultSet.next())
				return resultSet.getString(1);
			return new String();
		}finally{
			connection.close();
		}
	}
	
	
	static public Tag getTagByName(String tagName) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doUpdate = "select * from " +tablename+ " where tagName='" +tagName+ "'";
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			ResultSet resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return new Tag();
			return new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(7), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
		}finally{
			connection.close();
		}
	}
	static public List<Tag> sortTags() throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Tag> taglist = new ArrayList<Tag>();
		try{
			String doUpdate = "select * from " +tablename+ " order by tagAttention desc limit 0,4";
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
				taglist.add(new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(7), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
			return taglist;
		}finally{
			connection.close();
		}
	}
	static public List<Tag> allTags() throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Tag> taglist = new ArrayList<Tag>();
		try{
			String doUpdate = "select * from " +tablename;
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
				taglist.add(new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(7), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6)));
			return taglist;
		}finally{
			connection.close();
		}
	}
	
	static public boolean checkTag(int tagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Tag> taglist = new ArrayList<Tag>();
		try{
			String doUpdate = "select 1 from " +tablename+ " where id="+tagId;
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			ResultSet resultSet = prepareState.executeQuery();
			if(!resultSet.next())

				return false;
			return true;
		}finally{
			connection.close();
		}
	}
	
}
