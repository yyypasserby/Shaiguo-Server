package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DBRelationAPI {

	private String tablename;
	private ResultSet  resultSet;
	private PreparedStatement prepareState;
	private List<Integer> list;
	public DBRelationAPI() throws SQLException{
		tablename = "UserRelation";
	}
	
	public boolean insertRelation(int fromId, int toId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doInsert = "insert " +tablename+ " (from_id, to_id) values ( " +fromId+ "," +toId+" )";
		prepareState = connection.prepareStatement(doInsert);
		return prepareState.execute();
		}finally{
			connection.close();
		}
	}
	
	public boolean deleteRelation(int fromId, int toId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doDelete = "delete from " +tablename+ " where from_id= " +fromId+ " and to_id= "+toId;
		prepareState = connection.prepareStatement(doDelete);
		return prepareState.execute();
		}finally{
			connection.close();
		}
	}
	
	public List<Integer> queryRelationFrom(int fromId) throws  SQLException{
		list = new ArrayList<Integer>();
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select * from " +tablename+" where from_id= " +fromId;
			prepareState = connection.prepareStatement(doQuery);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				list.add(resultSet.getInt(3));
			return list;
		}finally{
			connection.close();
		}
	}
	
	public List<Integer> queryRelationTo(int toId) throws  SQLException{
		list = new ArrayList<Integer>();
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select * from " +tablename+" where to_id= " +toId;
			prepareState = connection.prepareStatement(doQuery);
			resultSet = prepareState.executeQuery();
			while(resultSet.next())
				list.add(resultSet.getInt(2));
			return list;
		}finally{
			connection.close();
		}
	}
}
