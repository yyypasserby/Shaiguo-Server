/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.lives.model.Message;

/**
 * @author yyypasserby
 *
 */
@Path("message")
public class MessageResource {
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<Message> getUserMessage(@PathParam("userId") int userId) {
		List<Message> messages = new ArrayList<>();
		return messages;
	}
}
