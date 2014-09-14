package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lives.model.Message;

public class DBMessageAPI {

	private static String tablename= "Action";
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	
	
	static public int insertAction(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if(getActionByUserId(userId).size()>0) return -1; 
			String doInsert = "insert into " +tablename+ " (userId,vid,type) values (" +userId+ ",0,0)";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int insertAction(int userId,int vid,int type) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if(getActionByUserId(userId).size()>0) return -1; 
			String doInsert = "insert into " +tablename+ " (userId,vid,type) values (" +userId+ ","+vid+","+type+")";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	
	static public int deleteAction(int actionId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doDelete = "delete from " +tablename+ " where id=" +actionId;
			prepareState = connection.prepareStatement(doDelete);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public List<Message> getActionByUserId(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Message>  messages = new ArrayList<Message>();
		try{
			String doCheck = "select * from " +tablename+ " where userId=" +userId;
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				messages.add(new Message(resultSet.getInt(1),resultSet.getInt(2), resultSet.getInt(3),resultSet.getInt(4),
						resultSet.getString(5)));
			return messages;
		}finally{
			connection.close();
		}
	}
	
	static public List<Integer> getActionIdByUserId(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Integer>  actionIds = new ArrayList<Integer>();
		try{
			String doCheck = "select id from " +tablename+ " where userId=" +userId;
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				actionIds.add(resultSet.getInt(1));
			return actionIds;
		}finally{
			connection.close();
		}
	}
	
	static public int updateAction(int actionId,int vid, int type) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "update " +tablename+ " set vid=" +vid+ ",type=" +type+ " where id=" +actionId;
			prepareState = connection.prepareStatement(doCheck);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
}
