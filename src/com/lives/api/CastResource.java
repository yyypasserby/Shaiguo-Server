/**
 * 
 */
package com.lives.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.Live;

/**
 * @author yyypasserby
 *
 */

@Path("/casting")
public class CastResource {
	@GET
	@Path("/{username}")
	@Produces("application/json")
	public Live getCasterByName(@QueryParam("username") String username) {
		return new Live();
	}
}
