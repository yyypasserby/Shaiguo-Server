package com.lives.api;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.Message;
import com.lives.model.UserAction;

/**
 * @author yyypasserby
 *
 */

@Path("/action")
public class ActionResource 
{
	@Path("/user")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public List<UserAction> getUserAction(@PathParam("userId") int userId)
	{
		List<UserAction> action = new ArrayList<>();
		action.add(new UserAction(0,1,0,0));
		action.add(new UserAction(0,2,2,0));
		return action;
	}
	
	@Path("/friend")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public List<UserAction> getUserFriendAction(@PathParam("userId") int userId)
	{
		List<UserAction> action = new ArrayList<>();
		return action;
	}
}
