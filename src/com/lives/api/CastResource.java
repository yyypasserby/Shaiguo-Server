/**
 * 
 */
package com.lives.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.Error;
import com.lives.api.helper.Result;
import com.lives.model.Live;
import com.lives.utils.DBCastAPI;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */

@Path("/casting")
public class CastResource {

	public static String byteArrayToHexString(byte[] b) {
		String result = "";
		for (int i = 0; i < b.length; i++) {
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}

	@GET
	@Path("/{username}")
	@Produces("application/json")
	public Live getCasterByName(@PathParam("username") String username)
			throws SQLException, NumberFormatException, ParseException {
		int vid = DBCastAPI.getVidByUsername(username);
		System.out.println(vid);
		if (vid <= 0)
			return new Live();
		return DBVideoAPI.getVideoById(vid);
	}

	@POST
	@Path("/apply")
	@Produces("application/json")
	public Result applyForCast(Live live) throws SQLException {
		String encrypt = live.getUserId() + "shaiguo" + Calendar.DATE;
		System.out.println(live.getUserId());
		System.out.println(live.getLivename());
		System.out.println(live.getTag());
		
		System.out.println(encrypt);
		MessageDigest md = null;
	    try {
	        md = MessageDigest.getInstance("SHA-1");
	    }
	    catch(NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    } 
	    String hash = byteArrayToHexString(md.digest(encrypt.getBytes()));
	    hash = hash.substring(13, 23);
	    if( DBVideoAPI.insertVideo(live.getTag(), live.getUserId(), hash, live.getLivename())>0)	    	
	    return new Result("succcess",hash);
	    return new Result("failed",new Error(0,"insert video error"));
	}
}
