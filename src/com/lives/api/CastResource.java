/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.Live;
import com.lives.utils.DBCastAPI;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */

@Path("/casting")
public class CastResource {
	@GET
	@Path("/{username}")
	@Produces("application/json")
	public Live getCasterByName(@PathParam("username") String username) throws SQLException, NumberFormatException, ParseException {
		int vid=DBCastAPI.getVidByUsername(username);
		System.out.println(vid);
		if(vid==0)
			return new Live();
		return DBVideoAPI.getVideoById(vid);
	}
}
