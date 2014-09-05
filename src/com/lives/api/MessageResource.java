/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.Message;

/**
 * @author yyypasserby
 *
 */
@Path("message")
public class MessageResource {
	@GET
	@Produces("application/json")
	public List<Message> getUserMessage(@QueryParam("userId") Integer userId) {
		if(userId == null) return null;
		List<Message> messages = new ArrayList<>();
		messages.add(new Message("icon_tiny","DUODUO DOTA2 CASTING","back1","17:00","Living"));
		messages.add(new Message("icon_tiny","DUODUO DOTA2 CASTING","back2","18:00","Stopped"));
		messages.add(new Message("icon_tiny","DUODUO DOTA2 CASTING","back3","8:00","To Cast"));
		return messages;
	}
}
