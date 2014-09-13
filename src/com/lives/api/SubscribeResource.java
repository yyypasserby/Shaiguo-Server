/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.utils.DBRelationAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/subscribe")
public class SubscribeResource {
	
	@GET
	@Produces("application/json")

	public Result subscribe(@QueryParam("from_id") Integer fromId, @QueryParam("to_id") Integer toId) throws SQLException {
		if(fromId == null || toId == null) return new Result("false");
		if(DBRelationAPI.checkRelation(fromId, toId))
			return new Result("failed",new Error(0,"it exits!"));
		DBRelationAPI.insertRelation(fromId, toId);
		return new Result("success");
	}
	
	@GET
	@Path("/check")
	@Produces("application/json")
	public Result checkSubscribe(@QueryParam("from_id") Integer fromId, @QueryParam("to_id") Integer toId) throws SQLException {
		System.out.println("from_id : " + fromId + " to_id : " + toId);
		if(fromId == null || toId == null) return new Result("false", "param is wrong");
		if(DBRelationAPI.checkRelation(fromId, toId))
			return new Result("true");
		return new Result("false");
	}
}
