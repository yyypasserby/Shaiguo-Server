/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.User;

/**
 * @author yyypasserby
 *
 */
@Path("/user")
public class UserResource {
	@GET
	@Produces("application/json")
	public User getUser(@QueryParam("userId") int userId) {
		User user = new User(0, "yyypasserby", "yiyunyao@shaiguo.com", 0);
		return user;
	}
	
	@POST
	//@Path("/addUser")
	@Consumes("application/json")
	@Produces("application/json")
	public String postUser(User user) {
		System.out.println("username: " + user.getUsername());
		//System.out.println("password: " + user.getPassword());
		System.out.println("email   : " + user.getEmail());
		return "{\"result\" : true}";
	}
	
}
