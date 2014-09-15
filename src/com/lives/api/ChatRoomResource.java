/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lives.api.helper.Result;
import com.lives.model.ChatMessage;

/**
 * @author yyypasserby
 *
 */

@Path("/chat")
public class ChatRoomResource {
	
	@POST
	@Path("/send/{userId}")
	@Consumes("application/json")
	@Produces("application/json")
	public Result sendChatContent(ChatMessage content, @PathParam("userId") int userId) {
		System.out.println(userId);
		System.out.println(content.getUserId());
		System.out.println(content.getUsername());
		System.out.println(content.getContent());
		System.out.println(content.getTime());
		return new Result();
	}
	
	@GET
	@Path("/receive/{userId}")
	@Produces("application/json")
	public List<ChatMessage> getChatPool(@PathParam("userId") int userId) {
		System.out.println(userId);
		List<ChatMessage> msgs = new ArrayList<>();
		msgs.add(new ChatMessage());
		return msgs;
	}
}
