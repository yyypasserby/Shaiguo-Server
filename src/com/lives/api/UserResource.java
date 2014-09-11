/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.lives.api.helper.Result;
import com.lives.api.helper.Error;

import com.lives.model.User;

/**
 * @author yyypasserby
 *@write by liucan in data 2014.9.7
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
	
	
	/*
	 * function:
	 * add a new user (regist)
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Result postUser(User user) {
		boolean res = true;
//		String match_email="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
//		String match_name="^[a-z0-9_-]{3,15}$";
//		String match_pwd="((?=.*\\d)(?=.*[a-z]).{6,20})";
//		
//		Pattern p=Pattern.compile(match_name);
//		Matcher m=p.matcher(user.getUsername());
//		res=m.matches();
//		if(res)
//		{
//			p=Pattern.compile(match_email);
//			m=p.matcher(user.getEmail());
//			res=m.matches();
//		}
//		
		//To Do
		//check username is not same to name in mysql
		
		if(res)
		{
			//To Do
			//Save in MySql
			return new Result("success", user);
		}
		else
		{
			return new Result("failed", new Error(0, "USERNAME_NOT_VALID"));
		}
	}
	
	

}
