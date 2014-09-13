package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class DBStreamStatusAPI 
{
	private static String Usertablename="User";
	private static String Videotablename="Video";
	private static ResultSet resultSet;
	private static PreparedStatement prepareState;
	
	static public String Change_User_Status(String name,int status) throws NumberFormatException, SQLException, ParseException
	{
		Connection connection = DBPool.getInstance().getConnection();
		try
		{
			int res=-1;
			int id=Select_userIDBy_location(name);
			if(id<0)
			{
				return "no user found this stream name!!";
			}
			else
			{
				int userstatus=0;
				if(status==0)
				{
					userstatus=0;
				}
				else if(status==1)
				{
					userstatus=2;
				}
				String sql = "UPDATE `"+Usertablename+"` SET `status`="+userstatus+" WHERE `id`="+id+";";
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				if(res>0)
				{
					return "change status success!";
				}
				else
				{
					return "change status failed!";
				}
			}
		}
		finally{
			connection.close();
		}
	}
	
	static public int Select_userIDBy_location(String name) throws NumberFormatException, SQLException, ParseException
	{
		Connection connection = DBPool.getInstance().getConnection();
		try
		{
			int id=-1;
			String sql = "SELECT `userId` FROM `"+Videotablename+"` WHERE `location`=\""+name+"\";";
			prepareState = connection.prepareStatement(sql);
			resultSet=prepareState.executeQuery();
			if(resultSet.next()) 			
			{
				id=resultSet.getInt("userId");
			}
			return id;
		}
		finally{
			connection.close();
		}
	}
	
}
