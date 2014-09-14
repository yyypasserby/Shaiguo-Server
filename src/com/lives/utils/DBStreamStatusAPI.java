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
		finally{
			connection.close();
		}
	}
}
