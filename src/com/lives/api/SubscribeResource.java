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
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/subscribe")
public class SubscribeResource {
	
	@GET
	@Produces("application/json")

	public Result subscribe(@QueryParam("from_id") Integer fromId, @QueryParam("to_id") Integer toId) throws SQLException {
		if(fromId == null || toId == null) return new Result("false",new Error(0,"PARAM_IS_WRONG"));
		if(DBRelationAPI.checkRelation(fromId, toId))
			return new Result("failed",new Error(0,"RELATION_EXITS"));
		if(DBUserAPI.checkId(fromId)&&DBUserAPI.checkId(toId)){
			DBRelationAPI.insertRelation(fromId, toId);
			DBUserAPI.addUserAttention(toId);
			return new Result("success");
		}
		return new Result("failed",new Error(0,"USER_NOT_EXITS"));
	}
	
	@GET
	@Path("/check")
	@Produces("application/json")
	public Result checkSubscribe(@QueryParam("from_id") Integer fromId, @QueryParam("to_id") Integer toId) throws SQLException {
		System.out.println("from_id : " + fromId + " to_id : " + toId);
		if(fromId == null || toId == null) return new Result("false", "PARAM_IS_WRONG");
		if(DBRelationAPI.checkRelation(fromId, toId))
			return new Result("true");
		return new Result("false");
	}
}
