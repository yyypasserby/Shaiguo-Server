package com.lives.api;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.Result;
import com.lives.model.Message;
import com.lives.utils.DBFriendActionAPI;
import com.lives.utils.DBRelationAPI;
import com.lives.utils.DBMessageAPI;

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
//		List<Integer> friends = DBRelationAPI.queryRelationFrom(userId);
//		List<Integer> actions = new ArrayList<Integer>();
//		for(int i=0;i<friends.size();i++)
//			actions.addAll(DBUserActionAPI.getActionIdByUserId(friends.get(i)));
//		List<Prediction>
		List<Message> actions = DBFriendActionAPI.getFriendActionById(userId);
		return actions;
	}
	
	@POST
	@Path("/receive")
	@Consumes("application/json")
	@Produces("application/json")
	public Result receiveAction(Message action) {
		System.out.println(action.getUserId());
		System.out.println(action.getVid());
		System.out.println(action.getType());
		return new Result("success");
	}
}
