package com.lives.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DBStreamStatusAPI 
{
	private static String Usertablename="User";
	private static String Videotablename="Video";
	private static String Casttablename="Cast";
	
	static public String Change_User_Status(String name,int status,String save) throws NumberFormatException, SQLException, ParseException
	{
		Connection connection = DBPool.getInstance().getConnection();
		try
		{
			String reply="";

			int res=-1;
			int userstatus=0;
			if(status==0){
				userstatus=0;
			}
			else if(status==1){
				userstatus=1;
			}
			String sql = "UPDATE `"+Usertablename+"` INNER JOIN `"+Videotablename+"`  SET status = "+userstatus+", extravid=Video.id WHERE "+Videotablename+".userId=User.id AND "+Videotablename+".location=\""+name+"\";";
			PreparedStatement prepareState = connection.prepareStatement(sql);
			res=prepareState.executeUpdate();
			prepareState.close();
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
			ResultSet resultSet=prepareState.executeQuery();
			if (resultSet.next()) 
			{
				vid=resultSet.getInt("id");
				userId=resultSet.getInt("userId");
			}
			prepareState.close();
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
				prepareState.close();
				if(res>0)
				{
					reply+="\nInsert Cast Status: "+status+" Success!";
				}
				else
				{
					reply+="\nInsert Cast Status: "+status+" Failed!";
				}
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String casttime = sdf.format(date);
				sql = "update "+Videotablename+ " set casttime='"+casttime+"' where id="+vid;
				DBMessageAPI.insertAction(userId, vid, 1, casttime);
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				prepareState.close();
			}
			else
			{
				sql = "UPDATE `"+Casttablename+"` SET state = "+status+" WHERE userId="+userId+" AND vid="+vid+";";
				System.out.println(sql);
				prepareState = connection.prepareStatement(sql);
				res=prepareState.executeUpdate();
				prepareState.close();
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
				prepareState.close();
				if(res>0)
				{
					reply+= "\nUpdate Vedio location: "+save+" Success!";
				}
				else
				{
					reply+= "\nUpdate Vedio location: "+save+" Failed!";
				}
			}
			System.out.println("finish");
			return reply;
		}
		finally{
			connection.close();
		}
	}
}
