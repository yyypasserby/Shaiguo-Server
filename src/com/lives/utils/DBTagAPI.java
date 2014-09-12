package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lives.model.Tag;

public class DBTagAPI {

	private static String tablename= "Tag";
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	
	
	static public int insertTag(String tagName,String thumbnailSmall,String thumbnailBig) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if(getTagByName(tagName)!=null) return -1;
			String doInsert = "insert into " +tablename+ " (tagName,tagAttention,tagPathBig,tagPathSmall) values ('" 
					+tagName+        "',0,'"
					+thumbnailSmall+ "','"
					+thumbnailBig+   "') ";
			prepareState = connection.prepareStatement(doInsert);
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
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int  deleteTag(int tagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+ " where id=" +tagId;
			prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
//			return prepareState.execute();
		}finally{
			connection.close();
		}
	}
	
	static public int updateTagAttention(int tagId, int tagAttention) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "update " +tablename+ " set tagAttention=" +tagAttention+ " where tagId=" +tagId;
			prepareState = connection.prepareStatement(doCheck);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	

	static public int updateTagLiveNumber(int tagId, int liveNumber) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "update " +tablename+ " set liveNumber=" +liveNumber+ " where tagId=" +tagId;
			prepareState = connection.prepareStatement(doCheck);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public Tag getTagById(int tagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "select * from " +tablename+ " where id=" +tagId;
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return new Tag();
			return new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
		}finally{
			connection.close();
		}
	}
	
	static public Tag getTagByName(String tagName) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doUpdate = "select * from " +tablename+ " where tagName='" +tagName+ "'";
			prepareState = connection.prepareStatement(doUpdate);
			resultSet = prepareState.executeQuery();
			if(!resultSet.next())
				return new Tag();
			return new Tag(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3),resultSet.getInt(4),resultSet.getString(5),resultSet.getString(6));
		}finally{
			connection.close();
		}
	}
}
