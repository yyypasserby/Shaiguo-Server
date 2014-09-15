package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DBRelationAPI {

	private static String tablename= "UserRelation";
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	
	static public int insertRelation(int fromId, int toId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		
		String doInsert = "insert " +tablename+ " (from_id, to_id) values ( " +fromId+ "," +toId+" )";
		prepareState = connection.prepareStatement(doInsert);
		return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int deleteRelation(int fromId, int toId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doDelete = "delete from " +tablename+ " where from_id= " +fromId+ " and to_id= "+toId;
		prepareState = connection.prepareStatement(doDelete);
		return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public List<Integer> queryRelationFrom(int fromId) throws  SQLException{
		List<Integer> list = new ArrayList<Integer>();
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select to_id from " +tablename+" where from_id= " +fromId;
			prepareState = connection.prepareStatement(doQuery);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				list.add(resultSet.getInt(1));
			return list;
		}finally{
			connection.close();
		}
	}
	
	static public boolean checkRelation(int fromId,int toId) throws  SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select to_id from " +tablename+" where from_id= " +fromId+ " and to_id=" +toId;
			prepareState = connection.prepareStatement(doQuery);
			resultSet = prepareState.executeQuery();
			if(resultSet.next())
				return true;  //it exits 
			return false;	  
		}finally{
			connection.close();
		}
	}
	
	static public List<Integer> queryRelationTo(int toId) throws  SQLException{
		List<Integer> list = new ArrayList<Integer>();
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select from_id from " +tablename+" where to_id= " +toId;
			prepareState = connection.prepareStatement(doQuery);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				list.add(resultSet.getInt(1));
			return list;
		}finally{
			connection.close();
		}
	}
}
