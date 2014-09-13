package com.lives.api;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author yyypasserby
 *
 */

@Path("/fms")
public class FMSResource {
	@GET
	@Produces("application/json")
	public String streamChange(@QueryParam("streamname") String name,@QueryParam("status") int status) 
	{
		/*
		 * status
		 * 0------stop
		 * 1------play
		 */
		return "{\"Stream:\" "+name+" \"status\": "+status+"}";
	}
}
