/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lives.model.Message;
import com.lives.utils.DBFriendActionAPI;
import com.lives.utils.DBMessageAPI;

/**
 * @author yyypasserby
 *
 */
@Path("message")
public class MessageResource {
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<Message> getUserMessage(@PathParam("userId") int userId) throws SQLException {
		return DBMessageAPI.getActionByUserId(userId);
	}
}
