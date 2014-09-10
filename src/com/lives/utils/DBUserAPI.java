package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lives.model.User;

public class DBUserAPI {
	private String tablename;
	private ResultSet  resultSet;
	private PreparedStatement prepareState;
	
	public DBUserAPI() throws ClassNotFoundException, SQLException{
	}

	public boolean insertUser(String user_name,String pwd,String email,String Tag) throws SQLException, ClassNotFoundException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		tablename = "User";
		String doInsert = "insert into " + tablename + "(username,password,email,tags) values('"+ user_name + "','" + pwd +"','"+ email+"','"+ Tag +"')";
		prepareState = connection.prepareStatement(doInsert);
		return prepareState.execute();
		}
		finally{
			connection.close();
		}
	}
	
	public boolean deleteUser(int user_id) throws SQLException, ClassNotFoundException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		tablename="User";
		String doDelete = "delete from " + tablename + " where id = '" + user_id+"'";
		prepareState = connection.prepareStatement(doDelete);
		return prepareState.execute();
		}
		finally{
			connection.close();
		}
	}
	
	public String checkUsername(String user_name) throws SQLException, ClassNotFoundException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		tablename="User";
		String doCheck = "select * from " + tablename +" where username = '" + user_name+ "'";
		prepareState = connection.prepareStatement(doCheck);
		resultSet=prepareState.executeQuery();
		if(resultSet.next()) 	return "USERNAME_IS_USED"; //used
		return "USERNAME_IS_OK"; //this name is ok
		}
		finally{
			connection.close();
		}
	}
	
	public boolean updateUser(int userid,String username,String password,String email, String tag) throws SQLException, ClassNotFoundException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			tablename = "User";
			String doUpdate = "update " +tablename+ 
				  " SET username='" + username +
					"', password='" + password +
					"', email ='"   + email +
					"', tag ='"     + tag +
					"' where id='"  + userid + "'";
			prepareState = connection.prepareStatement(doUpdate);
			return prepareState.execute();
		} finally{
			connection.close();
		}
	}
	
	public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			tablename="User";
			if("USERNAME_IS_OK" == checkUsername(username)) return "USERNAME_NOT_MATCHED";
			String doCheck = "select * from " + tablename +" where username = '" + username+ "' and password = '"+password+ "'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet=prepareState.executeQuery();
			if(resultSet.next())	return resultSet.getString(1);
			return "USERNAME_PASSWORD_NOT_MATCHED"; //login failed
		}
		finally{
			connection.close();
		}
	}
	
	public User getUserById(int id) throws ClassNotFoundException, SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			tablename="User";
			String doCheck = "select * from " + tablename +" where id='"+ id +"'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet=prepareState.executeQuery();
			if(!resultSet.next()) 
				return null;
			resultSet.next();
			return new User(id, resultSet.getString(2), resultSet.getString(4), 0);
		}
		finally{
			connection.close();
		}
	}
	
	public String getUserId(String username) throws ClassNotFoundException, SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			tablename="User";
			String doCheck = "select * from " + tablename +" where username='"+ username +"'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet=prepareState.executeQuery();
			if(!resultSet.next()) 
			return null;
			return resultSet.getString(1);			
		} finally{
			connection.close();
		}

	}
	

}