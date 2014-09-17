package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.lives.model.User;

public class DBUserAPI {

	private static String tablename="User";

	public static String changeTagToString(List<Integer> tag){
		String a = tag.toString();
		a=a.replace("[", "");
		a=a.replace("]", "");
		a=a.replace(" ", "");
		return a;
	}
	
	static public List<String> changeTagToList(String tag){
		if(tag==null) return new ArrayList<String>();
		String[] arr = tag.split(",");
		List<String> list2=new ArrayList<>();
		for(int i=0;i<arr.length;i++){
			list2.add(arr[i]);
		}
		return list2;
	}
	
	static public int insertUser(String user_name,String pwd,String email,String tag,int castTagId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doInsert = "insert into " + tablename + " (username,password,email,tags,thumbnail,attention,castTagId,remainUps,hotRate,status) values('"
						+ user_name + "','" + pwd +"','"+ email+"','"+ tag+"','default.png',"+0+","+castTagId+","+3+","+0+","+0+")";
		PreparedStatement prepareState = connection.prepareStatement(doInsert);
		return prepareState.executeUpdate();
		}
		finally{
			connection.close();
		}
	}
	
	static public int insertUser(String user_name,String pwd,String email,String tag) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doInsert = "insert into " + tablename + " (username,password,email,tags,thumbnail,attention,remainUps,hotRate,status) values('"
						+ user_name + "','" + pwd +"','"+ email+"','"+ tag+"','default.png',"+0+","+3+","+0+","+0+")";
		PreparedStatement prepareState = connection.prepareStatement(doInsert);
		return prepareState.executeUpdate();
		}
		finally{
			connection.close();
		}
	}
	
	
	static public int deleteUser(int user_id) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doDelete = "delete from " + tablename + " where id = '" + user_id+"'";
		PreparedStatement prepareState = connection.prepareStatement(doDelete);
		return prepareState.executeUpdate();
		}
		finally{

			connection.close();
		}
	}

	static public String checkUsername(String user_name) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try{
		String doCheck = "select id from " + tablename +" where username = '" + user_name+ "'";
		PreparedStatement prepareState = connection.prepareStatement(doCheck);
		ResultSet resultSet=prepareState.executeQuery();
		if(resultSet.next()) 			//exit 	
			return "USERNAME_IS_USED";  //used
			return "USERNAME_IS_OK";    //this name is ok
		}
		finally{
			connection.close();
		}
	}
	
	static public int updateUser(int userid,String username,String password,String email, String tag) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doUpdate = "update " + tablename + " SET username='"
					+ username + "', password='" + password + "', email ='"
					+ email + "', tags ='" + tag + "'  where id='" + userid
					+ "'";
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			return prepareState.executeUpdate();
		} finally{
			connection.close();
		}
	}
	
	static public int updateUserTags(int userId,String tags) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doUpdate = "update " + tablename + " SET tags ='" +tags+ "' where id="+userId;
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			return prepareState.executeUpdate();
		} finally{
			connection.close();
		}
	}
	
	static public int updateUser(int userid,String username,String password,String email,String tag,int hotrate, int role,int status ,String extraVideo) throws SQLException{

		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doUpdate = "update " + tablename + " SET username='"
					+ username + "', password='" + password + "', email ='"
					+ email + "', tags ='" + tag + "', hotrate ='" + hotrate
					+ "', role ='" + role + "', status ='" + status
					+ "', extravideo ='" + extraVideo + "'  where id='"
					+ userid + "'";
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);

			return prepareState.executeUpdate();
		} finally{
			connection.close();
		}
	}

	static public String checkLogin(String username, String password)
			throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try{
			if("USERNAME_IS_OK" == checkUsername(username)) return "USERNAME_NOT_EXIST";
			String doCheck = "select id from " + tablename +" where username = '" + username+ "' and password = '"+password+ "' ";

			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			ResultSet resultSet = prepareState.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				return resultSet.getString(1);
			}
			return "USERNAME_PASSWORD_NOT_MATCHED"; // login failed
		} finally {
			connection.close();
		}
	}

	static public User getUserById(int id) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doCheck = "select * from " + tablename + " where id='" + id
					+ "'";
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			ResultSet resultSet = prepareState.executeQuery();
			if (!resultSet.next())

				return new User();
			System.out.println("id" + id);
			return new User(id, resultSet.getString(2), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9),
						resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12),resultSet.getInt(13));
		}
		finally{
			connection.close();
		}
	}
	
	static public String getUserNameById(int id) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doCheck = "select username from " + tablename + " where id=" + id+ " limit 0,1";
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			ResultSet resultSet = prepareState.executeQuery();
			if (!resultSet.next())
				return new String();
			return resultSet.getString(1);
		}
		finally{
			connection.close();
		}
	}

	static public String getUserId(String username) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doCheck = "select id from " + tablename +" where username='"+ username +"'";
			PreparedStatement prepareState = connection.prepareStatement(doCheck);
			ResultSet resultSet = prepareState.executeQuery();
			if (!resultSet.next())
				return "";
			return resultSet.getString(1);
		} finally {
			connection.close();
		}
	}
	
	static public User getUserByName(String username) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		List<User> users = new ArrayList<User>();
		System.out.println(username);
		try {
			String doCheck = "select * from " + tablename
					+ " where username ='" + username + "'";
			PreparedStatement prepareState = connection.prepareStatement(doCheck);

			ResultSet resultSet=prepareState.executeQuery();
			if(!resultSet.next())
				return new User();
			return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5),
					resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9),
					resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12),resultSet.getInt(13));

		} finally {
			connection.close();
		}
	}
	

	static public List<User> searchUserByName(String username) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		List<User> users = new ArrayList<User>();
		System.out.println(username);
		try {
			String doCheck = "select * from " + tablename
					+ " where username like '%" + username + "%'";
			PreparedStatement prepareState = connection.prepareStatement(doCheck);

			ResultSet resultSet=prepareState.executeQuery();
			while(resultSet.next())
				users.add(new User(resultSet.getInt(1),resultSet.getString(2), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9),
						resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12),resultSet.getInt(13)));

			return users;
		} finally {
			connection.close();
		}
	}
	
	
	
	static public String searchPreName(String key) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doSearch = "select username from " +tablename+ 
					" where username like '%" +key+ "%' limit 0,1";
			PreparedStatement prepareState = connection.prepareStatement(doSearch);
			ResultSet resultSet = prepareState.executeQuery();
			if(resultSet.next())
				return resultSet.getString(1);
			return new String();
		}finally{
			connection.close();
		}
	}
	
	
	static public List<User> sortUsers() throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<User> users = new ArrayList<User>();
		try{
			String doUpdate = "select * from " +tablename+ " order by hotrate desc limit 0,4";
			PreparedStatement prepareState = connection.prepareStatement(doUpdate);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
				users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getString(5),
						resultSet.getInt(6),resultSet.getInt(7),resultSet.getInt(8),resultSet.getString(9),
						resultSet.getInt(10),resultSet.getInt(11),resultSet.getInt(12),resultSet.getInt(13)));		
			return users;
		}finally{
			connection.close();
		}
	}
	
	static public List<List> getUserTags() throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<List> taglist = new ArrayList<>();
		try{
			String doQuery = "select tags from User";
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
				taglist.add(changeTagToList(resultSet.getString(1)));
			return taglist;
		}finally{
			connection.close();
		}
	}
	
	static public boolean checkId(int id) throws SQLException{
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
	
	static public int updateUserThumb(int id,String thumbnail) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set thumbnail='"+thumbnail+"' where id="+id; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int updateUserExtra(int userId,int vid,int status) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set extravid='"+vid+"', sratus="+status+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int updateUserHotRate(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set hotRate=hotRate+1 where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int updateUserStatus(int userId,int status) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set status="+status+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
		
	static public int updateUserAttention(int userId,int attention) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set attention="+attention+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
	
	static public int addUserAttention(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set attention=attention+1 where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}			
	}
	
	static public int getUserRemains(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "select remainUps from "+tablename+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet= prepareState.executeQuery();
			if(!resultSet.next())
				return -1;
			return resultSet.getInt(1);
		}finally{
			connection.close();
		}	
	}

	static public int subUserRemains(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update "+tablename+" set remainUps=remainUps-1 where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}	
	}
	
	static public int addUserHotRate(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update "+tablename+" set hotrate=hotrate+1 where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}	
	}	
	
	static public int updateUserRemains(int userId,int remain) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update "+tablename+" set remainUps="+remain+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}	
	}	
		
	
	static public int setUserRemains(int userId) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update "+tablename+" set remainUps=3 where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}	
	}

	
	static public int updateUserCastTag(int userId,int castTag) throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		try{
			String doQuery = "update " +tablename+ " set castTagId="+castTag+" where id="+userId; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}			
	}
	
	static public List<Integer> getAllUserId() throws SQLException{
		Connection connection = DBPool.getInstance().getConnection();
		List<Integer> idList=new ArrayList<>();
		try{
			String doQuery = "select id from User"; 
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet = prepareState.executeQuery();
			while(resultSet.next())
				idList.add(resultSet.getInt(1));
			return idList;
		}finally{
			connection.close();
		}	
	}
	
}
