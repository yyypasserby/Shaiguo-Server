package com.lives.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBExecutor {

	final static String dbName = "com.mysql.jdbc.Driver";
	final static String url = "jdbc:mysql://223.3.80.99:3306/Shaiguotest";
	private String username = "admin";
	private String pwd = "140";
	private String tablename;
	private ResultSet  result_set;
	private PreparedStatement prepare_state;
	private DBHelper dbHelper ;
	boolean execut_test;
	
	public class DBHelper  {

		private Connection connection;
		public DBHelper() throws ClassNotFoundException, SQLException{
			connection=getConnection();
		}
		
		public Connection getConnection() throws ClassNotFoundException, SQLException{

			Class.forName(dbName);
			return connection = DriverManager.getConnection(url, username, pwd);
		}
		
		public void closeConnection() throws SQLException{
			this.connection.close();
		}
	}

	public DBExecutor() throws ClassNotFoundException, SQLException{
			dbHelper = new DBHelper();
	}

	public static void main(String[] argc) throws SQLException, ClassNotFoundException{
		DBExecutor dbexe = new DBExecutor();
			if(dbexe.checkUsername("lebi1"))
				System.out.println("has it");
	}

	public boolean insertUser(String user_name,String pwd,String email,String Tag) throws SQLException, ClassNotFoundException{
		
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//		connection = DriverManager.getConnection(url, username, pwd);
		Connection connection = dbHelper.getConnection();
		try{
		tablename = "User";
		String do_insert = "insert into " + tablename + "(username,password,email,tags) values('"+ user_name + "','" + pwd +"','"+ email+"','"+ Tag +"')";
		prepare_state = connection.prepareStatement(do_insert);
		return prepare_state.execute();
		}
		finally{
			dbHelper.closeConnection();
		}
	}
	
	public boolean deleteUser(int user_id) throws SQLException, ClassNotFoundException{
		Connection connection = dbHelper.getConnection();
		try{
		tablename="User";
		String do_delete = "delete from " + tablename + " where id = '" + "user_id'";
		prepare_state = connection.prepareStatement(do_delete);
		return prepare_state.execute();
		}
		finally{
			dbHelper.closeConnection();
		}
	}
	
	public boolean checkUsername(String user_name) throws SQLException, ClassNotFoundException{
		Connection connection = dbHelper.getConnection();
		try{
		tablename="User";
		String do_check = "select * from " + tablename +" where username = '" + user_name+ "'";
		prepare_state = connection.prepareStatement(do_check);
		result_set=prepare_state.executeQuery();
		if(!result_set.wasNull()) return true; //this name is used
		return false; //not used
		}
		finally{
			dbHelper.closeConnection();
		}
	}
	
}
