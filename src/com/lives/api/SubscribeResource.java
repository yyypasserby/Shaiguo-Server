/**
 * 
 */
package com.lives.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.Result;

/**
 * @author yyypasserby
 *
 */
@Path("/subscribe")
public class SubscribeResource {
	@GET
	@Produces("applicaiton/json")
	public Result subscribe(@QueryParam("from_id") int fromId, @QueryParam("to_id") int toId) {
		System.out.println("from_id = " + fromId + ", to_id = " + toId);
		return new Result("success");
	}
	
	@GET
	@Path("/check")
	@Produces("application/json")
	public Result checkSubscribe(@QueryParam("from_id") int fromId, @QueryParam("to_id") int toId) {
		System.out.println("check: from_id = " + fromId + ", to_id = " + toId);
		return new Result("true");
	}
}
