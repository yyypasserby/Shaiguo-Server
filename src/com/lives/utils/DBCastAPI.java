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
	private static String condition=tablename1+".username";
	private static String orderBy=tablename2+".time"; 
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	
	static public int getVidByUsername(String username) throws SQLException{
		Connection connection=DBPool.getInstance().getConnection();
		try{
			String doQuery = "select vid from " +tablename1+ " inner join " +tablename2+
					 " where " +firstParam+ "=" +secondParam+ " and " +condition+
					"='" +username+ "'";
			System.out.println(doQuery);
			prepareState = connection.prepareStatement(doQuery);
			resultSet= prepareState.executeQuery();
			if(!resultSet.next())
				return 0;
			return resultSet.getInt(1);				
		}finally{
			connection.close();
		}
	}
}
