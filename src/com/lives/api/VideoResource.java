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

import com.lives.model.Live;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */
@Path("video")
public class VideoResource {
	@GET
	@Path("/{vid}")
	@Produces("application/json")
	public Live getLiveById(@PathParam("vid") int vid) throws NumberFormatException, SQLException, ParseException {
		return DBVideoAPI.getVideoById(vid);
	}
}
