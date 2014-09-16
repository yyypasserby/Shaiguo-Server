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
	private static String Casttablename="Cast";
	private static ResultSet resultSet;
	private static PreparedStatement prepareState;
	
	static public String Change_User_Status(String name,int status,String save) throws NumberFormatException, SQLException, ParseException
	{
		Connection connection = DBPool.getInstance().getConnection();
		try
		{
			String reply="";
			int res=-1;
			int userstatus=0;
			if(status==0)
			{
				userstatus=0;
			}
			else if(status==1)
			{
				userstatus=2;
			}
			String sql = "UPDATE `"+Usertablename+"` INNER JOIN `"+Videotablename+"`  SET status = "+userstatus+" WHERE "+Videotablename+".userId=User.id AND "+Videotablename+".location=\""+name+"\";";
			PreparedStatement prepareState = connection.prepareStatement(sql);
			res=prepareState.executeUpdate();
			if(res>0)
			{
				reply+= "Update User Status: "+userstatus+" Success!";
			}
			else
			{
				reply+= "Update User Status: "+userstatus+" Failed!";
			}
			
			int vid=-1;
			int userId=-1;
			String username="";
			sql =  "SELECT `id`,`userId` FROM "+Videotablename+" WHERE location=\""+name+"\";";
			prepareState = connection.prepareStatement(sql);
			resultSet=prepareState.executeQuery();
			if (resultSet.next()) 
			{
				vid=resultSet.getInt("id");
				userId=resultSet.getInt("userId");
			}
			sql =  "SELECT `username` FROM "+Usertablename+" WHERE id="+userId+";";
			prepareState = connection.prepareStatement(sql);
			resultSet=prepareState.executeQuery();
			if (resultSet.next()) 
			{
				username=resultSet.getString("username");
			}
			
			if(status==1)
			{
				sql = "INSERT INTO `Cast` (id,vid,state,userId,username)VALUES(null,"+vid+","+status+","+userId+",\""+username+"\");";
				
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				if(res>0)
				{
					reply+="\nInsert Cast Status: "+status+" Success!";
				}
				else
				{
					reply+="\nInsert Cast Status: "+status+" Failed!";
				}
			}
			else
			{
				sql = "UPDATE `"+Casttablename+"` INNER JOIN `"+Videotablename+"`  SET state = "+status+" WHERE "+Videotablename+".userId="+userId+" AND "+Videotablename+".id="+vid+";";
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				if(res>0)
				{
					reply+= "\nUpdate Cast Status: "+status+" Success!";
				}
				else
				{
					reply+= "\nUpdate Cast Status: "+status+" Failed!";
				}
				
				sql = "UPDATE `"+Videotablename+"` SET location = \""+save+"\" WHERE location=\""+name+"\";";
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				if(res>0)
				{
					reply+= "\nUpdate Vedio location: "+save+" Success!";
				}
				else
				{
					reply+= "\nUpdate Vedio location: "+save+" Failed!";
				}
			}
			
			return reply;
		}
		finally{
			connection.close();
		}
	}
}
