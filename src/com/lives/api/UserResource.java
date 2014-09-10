/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.Session;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.model.User;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 *@write by liucan in data 2014.9.7
 *
 */
@Path("/user")
public class UserResource {
	private DBUserAPI userDB;
	public UserResource(){
		try {
			userDB = new DBUserAPI();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public User getUser(@PathParam("userId") int userId) throws ClassNotFoundException, SQLException {
		return userDB.getUserById(userId);
	}
	
	
	/*
	 * function:
	 * add a new user (regist)
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Result postUser(User user) throws ClassNotFoundException, SQLException {
	boolean res=false;
	String result;
	String match_email="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
	String match_name="^[a-z0-9_-]{3,15}$";
	
	
	Pattern p=Pattern.compile(match_name);
	Matcher m=p.matcher(user.getUsername());
	res=m.matches();
	if(!res)
		return new Result("failure", new Error(0,  "USERNAME_NOT_VALID"));
	p=Pattern.compile(match_email);
	m=p.matcher(user.getEmail());
	res=m.matches();
	if(!res)
		return new Result("failure", new Error(0, "EMAIL_NOT_VALID"));
		
	if("USERNAME_IS_USED".compareTo(result=user.register()) == 0)
		return new Result("failure", new Error(0, result));

	if("PASSWORD_NOT_VALID".compareTo(result=user.register()) == 0)
		return new Result("failure", new Error(0, result));
	
	user.setUserId(Integer.parseInt(result));
		return new Result("success", user);
	}	
}
