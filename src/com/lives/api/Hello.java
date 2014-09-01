/**
 * 
 */
package com.lives.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author yyypasserby
 *
 */

@Path("/hello")
public class Hello {
	@GET
	@Produces("application/json")
	public String sayHello() {
		return "{\"hello\" : \"hi\"}";
	}
}
