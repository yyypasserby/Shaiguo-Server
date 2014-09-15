/**
 * 
 */
package com.lives.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
	@Consumes("application/json")
	@Produces("application/json")
	public Result sendChatContent(ChatMessage content) {
		System.out.println(content.getUserId());
		System.out.println(content.getUsername());
		System.out.println(content.getContent());
		System.out.println(content.getTime());
		return new Result();
	}
}
