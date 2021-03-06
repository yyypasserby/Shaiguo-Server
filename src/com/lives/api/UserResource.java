/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.model.User;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 * @write by liucan in data 2014.9.7
 *
 */
@Path("/user")
public class UserResource {

	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public User getUser(@PathParam("userId") int userId)
			throws SQLException {
		System.out.println(userId);
		return DBUserAPI.getUserById(userId);
	}

	@GET
	@Path("/username/{username}")
	@Produces("application/json")
	public User getUserByUsername(@PathParam("username") String username) throws SQLException {
		return  DBUserAPI.getUserByName(username);
	}
	/*
	 * function: add a new user (regist)
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Result postUser(User user) throws ClassNotFoundException,
			SQLException {
		boolean res = false;
		String result;
		String match_email = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		String match_name = "^[a-z0-9_-]{3,15}$";
		
		Pattern p = Pattern.compile(match_name);
		
		Matcher m;

		try{
			m = p.matcher(user.getUsername());
		}catch(Exception e){
			return new Result("failure",new Error(0,"USERNAME_IS_EMPTY"));
		}
		res = m.matches();
		if (!res)
			return new Result("failure", new Error(0, "USERNAME_NOT_VALID"));
		p = Pattern.compile(match_email);
		try{
			m = p.matcher(user.getEmail());
		}catch(Exception e){
			return new Result("failure",new Error(0,"EMAIL_IS_EMPTY"));
		}
		res = m.matches();
		if (!res)
			return new Result("failure", new Error(0, "EMAIL_NOT_VALID"));

		if ("PASSWORD_NOT_VALID".compareTo(result = user.register()) == 0)
			return new Result("failure", new Error(0, result));

		else if ("USERNAME_IS_USED".compareTo(result) == 0)
			return new Result("failure", new Error(0, result));
		
		else if ("PASSWORD_IS_EMPTY".compareTo(result) == 0)
			return new Result("failure", new Error(0, result));


		user.setUserId(Integer.parseInt(result));
		return new Result("success", user);
		
	}
	
	@GET
	@Path("/modify/tags")
	@Consumes("application/json")
	@Produces("application/json")
	public Result modifyTags(@QueryParam("userId") int userId, @QueryParam("tags") String tags) throws SQLException {
		if(DBUserAPI.updateUserTags(userId, tags)>0)
			return new Result("success");
		return new Result("failed",new Error(0,"CHANGE_TAGS_FAILED"));
	}
	
	@GET
	@Path("/modify/castTagId")
	@Consumes("application/json")
	@Produces("application/json")
	public Result modifyUserAttrs(@QueryParam("userId") int userId, @QueryParam("castTagId") int castTagId) throws SQLException {
		if(DBUserAPI.updateUserCastTag(userId, castTagId)>0)
			return new Result("success");
		return new Result("failed",new Error(0,"CHANGE_CAST_TAG_FAILED"));
	}
	
	@GET
	@Path("/addOne")
	@Consumes("application/json")
	@Produces("application/json")
	public Result addOneHot(@QueryParam("userId") int userId, @QueryParam("casterId") int casterId) throws SQLException {
		int remain;
		if((remain=DBUserAPI.getUserRemains(userId))<0) 
			return new Result("failed",new Error(0,"USER_NOT_EXITS"));
		if(remain==0) 						
			return  new Result("failed",new Error(0,"REMAIN_NOT_ENOUGH"));
		if(DBUserAPI.subUserRemains(userId)<=0) 
			return  new Result("failed",new Error(0,"SUB_REMAIN_FAILED"));
		if(DBUserAPI.addUserHotRate(casterId)<=0)
			return new Result("failed",new Error(0,"ADD_REMAIN_FAILED"));
		return new Result("success");
	}
}
