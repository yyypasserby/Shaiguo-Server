package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lives.model.Message;

public class DBCastAPI {

	private static String tablename1="User";
	private static String tablename2="Cast";
	private static String firstParam=tablename1+".id";
	private static String secondParam=tablename2+".userId";
	private static String condition1=tablename1+".username";
	private static String condition2=tablename2+".state";
	private static String orderBy=tablename2+".time"; 
	
	static public int getVidByUsername(String username) throws SQLException{
		Connection connection=DBPool.getInstance().getConnection();
		try{
			String doQuery = "select vid from " +tablename1+ " inner join " +tablename2+
					 " where " +firstParam+ "=" +secondParam+ " and " +condition1+
					"='" +username+ "' and " +condition2+"=1";
			System.out.println(doQuery);
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			System.out.println(doQuery);
			ResultSet resultSet= prepareState.executeQuery();
			if(!resultSet.next())
				return 0;
			System.out.println(resultSet.getInt(1));
			return resultSet.getInt(1);
		}finally{
			connection.close();
		}
	}
	
	static public int deleteCast() throws SQLException{
		Connection connection=DBPool.getInstance().getConnection();
		try{
			String doQuery = "delete from "+tablename2+" where state= 0";
			PreparedStatement prepareState = connection.prepareStatement(doQuery);
			return prepareState.executeUpdate();
		}finally{
			connection.close();
		}
	}
}
