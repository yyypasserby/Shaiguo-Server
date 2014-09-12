package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lives.model.User;

public class DBUserAPI {
	private String tablename;
	private ResultSet resultSet;
	private PreparedStatement prepareState;

	public DBUserAPI() throws SQLException {
		tablename = "User";
	}

	public boolean insertUser(String user_name, String pwd, String email,
			String Tag) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doInsert = "insert into " + tablename
					+ "(username,password,email,tags) values('" + user_name
					+ "','" + pwd + "','" + email + "','" + Tag + "')";
			prepareState = connection.prepareStatement(doInsert);
			return prepareState.execute();
		} finally {
			connection.close();
		}
	}

	public boolean deleteUser(int user_id) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doDelete = "delete from " + tablename + " where id = '"
					+ user_id + "'";
			prepareState = connection.prepareStatement(doDelete);
			return prepareState.execute();
		} finally {
			connection.close();
		}
	}

	public String checkUsername(String user_name) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doCheck = "select * from " + tablename
					+ " where username = '" + user_name + "'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			if (resultSet.next()) // exit
				return "USERNAME_IS_USED"; // used
			return "USERNAME_IS_OK"; // this name is ok
		} finally {
			connection.close();
		}
	}

	public boolean updateUser(int userid, String username, String password,
			String email, String tag) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doUpdate = "update " + tablename + " SET username='"
					+ username + "', password='" + password + "', email ='"
					+ email + "', tags ='" + tag + "'  where id='" + userid
					+ "'";
			prepareState = connection.prepareStatement(doUpdate);
			return prepareState.execute();
		} finally {
			connection.close();
		}
	}

	public boolean updateUser(int userid, String username, String password,
			String email, String tag, int hotrate, int role, int status,
			String extraVideo) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doUpdate = "update " + tablename + " SET username='"
					+ username + "', password='" + password + "', email ='"
					+ email + "', tags ='" + tag + "', hotrate ='" + hotrate
					+ "', role ='" + role + "', status ='" + status
					+ "', extravideo ='" + extraVideo + "'  where id='"
					+ userid + "'";
			prepareState = connection.prepareStatement(doUpdate);
			return prepareState.execute();
		} finally {
			connection.close();
		}
	}

	public String checkLogin(String username, String password)
			throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			if ("USERNAME_IS_OK".compareTo(checkUsername(username)) == 0)
				return "USERNAME_NOT_EXIST";
			String doCheck = "select * from " + tablename
					+ " where username = '" + username + "' and password = '"
					+ password + "'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getString(1));
				return "success";
			}
			return "USERNAME_PASSWORD_NOT_MATCHED"; // login failed
		} finally {
			connection.close();
		}
	}

	public User getUserById(int id) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doCheck = "select * from " + tablename + " where id='" + id
					+ "'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			if (!resultSet.next())
				return null;
			return new User(id, resultSet.getString(2), resultSet.getString(4),
					resultSet.getString(5), Integer.parseInt(resultSet
							.getString(6)), Integer.parseInt(resultSet
							.getString(7)), Integer.parseInt(resultSet
							.getString(8)), resultSet.getString(9));
		} finally {
			connection.close();
		}
	}

	public String getUserId(String username) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		try {
			String doCheck = "select * from " + tablename + " where username='"
					+ username + "'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			if (!resultSet.next())
				return null;
			return resultSet.getString(1);
		} finally {
			connection.close();
		}
	}

	public List<User> searchUserByName(String username) throws SQLException {
		Connection connection = DBPool.getInstance().getConnection();
		List<User> users = new ArrayList<User>();
		System.out.println(username);
		try {
			String doCheck = "select * from " + tablename
					+ " where username like '%" + username + "%'";
			prepareState = connection.prepareStatement(doCheck);
			resultSet = prepareState.executeQuery();
			while (resultSet.next())
				users.add(new User(Integer.parseInt(resultSet.getString(1)),
						resultSet.getString(2), resultSet.getString(4),
						resultSet.getString(5), Integer.parseInt(resultSet
								.getString(6)), Integer.parseInt(resultSet
								.getString(7)), Integer.parseInt(resultSet
								.getString(8)), resultSet.getString(9)));
			return users;
		} finally {
			connection.close();
		}
	}
}