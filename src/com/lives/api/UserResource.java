/**
 * 
 */
package com.lives.api;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import com.lives.model.User;

/**
 * @author yyypasserby
 *
 */
@Path("/user")
public class UserResource {
	
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public User getUser(@PathParam("userId") int userId) {
		User user = new User(0, "yyypasserby", "yiyunyao@shaiguo.com", 0);
		return user;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postUser(User user) {
		System.out.println("username: " + user.getUsername());
		System.out.println("email   : " + user.getEmail());
		return "{\"result\" : true}";
	}
	
}
