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
					"='" +username+ "' and " +condition2+"=1  ORDER BY vid desc limit 0,1";
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
			String doDelete = "delete from "+tablename2+" where state= 0";
			PreparedStatement prepareState = connection.prepareStatement(doDelete);
			prepareState.executeUpdate();
			prepareState.close();
			String doQuery="select max(id),userId from Cast group by userId having count(userId )>1";
			prepareState = connection.prepareStatement(doQuery);
			ResultSet resultSet=prepareState.executeQuery();
			while(resultSet.next())
			{
				doDelete = "delete from Cast where userId="+resultSet.getInt(2)+" and id!="+resultSet.getInt(1);
				prepareState = connection.prepareStatement(doDelete);
				prepareState.execute();
			}
			return 0;
		}finally{
			connection.close();
		}
	}
}
