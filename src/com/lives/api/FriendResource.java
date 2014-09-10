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
import javax.ws.rs.QueryParam;

import com.lives.model.User;

/**
 * @author yyypasserby
 * 
 *
 */
@Path("/friend")
public class FriendResource {
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<User> getUserFriend(@PathParam("userId") int userId) {
		List<User> friends = new ArrayList<>();
		friends.add(new User(1,"dudu","dudu@shaiguo.com", 0));
		friends.add(new User(2,"duoduo","duoduo@shaiguo.com", 1));
		friends.add(new User(3,"yanyan","yanyan@shaiguo.com", 2));
		friends.add(new User(4,"cancan","cancan@shaiguo.com", 0));	
		return friends;
	}
}
