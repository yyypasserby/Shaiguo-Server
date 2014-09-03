/**
 * 
 */
package com.lives.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lives.model.User;

/**
 * @author yyypasserby
 *
 */
@Path("/user")
public class UserResource {
	@GET
	@Produces("application/json")
	public User getUser() {
		User user = new User();
		user.setUsername("yyypasserby");
		user.setEmail("yiyunyao@sina.cn");
		user.setImageSrc("images/yyy.png");
		return user;
	}
	
	@POST
	//@Path("/addUser")
	@Consumes("application/json")
	@Produces("application/json")
	public String postUser(User user) {
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email   : " + user.getEmail());
		return "{\"result\" : true}";
	}
}
