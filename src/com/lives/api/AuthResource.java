/**
 * 
 */
package com.lives.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lives.api.helper.Result;
import com.lives.api.helper.Error;
import com.lives.model.User;


/**
 * @author yyypasserby
 *
 */
@Path("/auth")
public class AuthResource {
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Result authenticated(User user) {
		String resStr;
		if(("success".compareTo(resStr = user.verify())) == 0) {
			return new Result("success", user);
		}
		return new Result("failure", new Error(0, resStr));
	}
}
