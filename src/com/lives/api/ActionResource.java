package com.lives.api;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import com.lives.api.helper.*;
import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.model.Live;
import com.lives.model.Message;
import com.lives.utils.DBFriendActionAPI;
import com.lives.utils.DBRelationAPI;
import com.lives.utils.DBMessageAPI;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */

@Path("/action")
public class ActionResource 
{
	@GET
	@Path("/user/{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Message> getUserAction(@PathParam("userId") int userId) throws SQLException
	{
		List<Message> messages = new ArrayList<>();
		messages=DBMessageAPI.getActionByUserId(userId);
		return messages;
	}
	
	@GET
	@Path("/friend/{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public List<Message> getUserFriendAction(@PathParam("userId") int userId) throws SQLException
	{
		List<Message> actions = DBFriendActionAPI.getFriendActionById(userId);
		return actions;
	}
	
	@POST
	@Path("/receive")
	@Consumes("application/json")
	@Produces("application/json")
	public Result receiveAction(Message action) throws SQLException {
		try{
			int res;
		if((res=DBMessageAPI.insertAction(action.getUserId(),action.getVid(),action.getType(),action.gettime()))>0)
			return new Result("success");
		if(res==-1)
			return new Result("failed",new Error(0,"USER_NOT_EXITS"));
		if(res==-2)
			return new Result("failed",new Error(0,"VIDEO_NOT_EXITS"));
			return new Result("failed",new Error(0,"INSERT_ACTION_FAILED"));
		}catch(Exception e){
			return new Result("failed",new Error(0,e.toString()));
		}
	}
	@POST
	@Path("/recommend")
	@Consumes("application/json")
	@Produces("application/json")
	public Result recommendLive(List<Integer> tags) throws NumberFormatException, SQLException, ParseException{
		List<Live> lives = new ArrayList<>();
		for(int i=0;i<tags.size();i++){
			lives.add(DBVideoAPI.recommendVideoByTag(tags.get(i)));
		}			
		return new Result("success",lives);
	}
}
