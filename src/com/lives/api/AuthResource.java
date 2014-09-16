/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lives.api.helper.Result;
import com.lives.api.helper.Error;
import com.lives.model.User;
import com.lives.utils.DBUserAPI;


/**
 * @author yyypasserby
 *
 */
@Path("/auth")
public class AuthResource {
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Result authenticated(User user) throws SQLException {
		String resStr=user.verify();
		if(resStr.length()<=11){
			try{
			user= DBUserAPI.getUserById(Integer.parseInt(resStr));
			}catch(Exception e){
				return new Result("failure",new Error(0,"USERID_IS_EMPTY"));
			}
				return new Result("success", user);
			
		}
			return new Result("failure", new Error(0, resStr));
	}
}
