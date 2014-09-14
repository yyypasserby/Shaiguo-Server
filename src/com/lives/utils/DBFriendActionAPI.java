package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lives.model.Message;

public class DBFriendActionAPI {

	private static String tablename1="UserRelation";
	private static String tablename2="Action";
	private static String firstParam=tablename1+".to_id";
	private static String secondParam=tablename2+".userId";
	private static String condition=tablename1+".from_id";
	private static String orderBy=tablename2+".time"; 
	private static ResultSet  resultSet;
	private static PreparedStatement prepareState;
	
	static public List<Message> getFriendActionById(int uid) throws SQLException{
		Connection connection=DBPool.getInstance().getConnection();
		List<Message> messages=new ArrayList<>();
		try{
			String doQuery = "select * from " +tablename1+ " inner join " +tablename2+
					" on " +firstParam+ "=" +secondParam+ " where " +condition+
					"=" +uid+ " order by " +orderBy+ " desc";
			prepareState = connection.prepareStatement(doQuery);
			resultSet= prepareState.executeQuery();
			while(resultSet.next())
				messages.add(new Message(resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),resultSet.getInt(7),
						resultSet.getString(8)));
			return messages;				
		}finally{
			connection.close();
		}
	}
}
