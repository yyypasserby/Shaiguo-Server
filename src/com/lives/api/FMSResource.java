package com.lives.api;
import java.sql.SQLException;
import java.text.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.utils.DBStreamStatusAPI;

/**
 * @author yyypasserby
 *
 */

@Path("/fms")
public class FMSResource {
	@GET
	@Produces("application/json")
	public String streamChange(@QueryParam("streamname") String name,@QueryParam("status") int status) throws NumberFormatException, SQLException, ParseException 
	{
		/*
		 * status
		 * 0------stop
		 * 1------play
		 */
		//return "helllo";
		String str=DBStreamStatusAPI.Change_User_Status(name,status);
		return str;
	}
}
