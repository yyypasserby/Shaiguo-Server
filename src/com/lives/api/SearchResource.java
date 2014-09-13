package com.lives.api;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.api.helper.PreSearchResult;
import com.lives.model.CachedVideo;
import com.lives.model.Live;
import com.lives.model.User;
import com.lives.utils.DBCachedVideoAPI;
import com.lives.utils.DBUserAPI;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/search")
public class SearchResource {
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public List<User> getUsersByName(@QueryParam("content") String username) throws SQLException {
		if(username == "null" || username == null) return new ArrayList<User>();
		return DBUserAPI.searchUserByName(username);
	}

	@GET
	@Path("/live")
	@Produces("application/json")
	public List<Live> getLivesByName(@QueryParam("content") String livename) throws NumberFormatException, SQLException, ParseException {
		if(livename == "null" || livename == null) return new ArrayList<Live>();
		return DBVideoAPI.searchVideoByName(livename);
	}
	
	@GET
	@Path("/cached")
	@Produces("application/json")
	public List<CachedVideo> getCachedByName(@QueryParam("content") String cachedname) throws NumberFormatException, SQLException, ParseException {
		if(cachedname == "" || cachedname == null) return new ArrayList<CachedVideo>();
		return DBCachedVideoAPI.searchCachedVideoByName(cachedname);
	}
	
	@GET
	@Path("/pre")
	@Produces("application/json")
	public List<PreSearchResult> getPreSearchResult(@QueryParam("content") String key) throws NumberFormatException, SQLException, ParseException {
		List<PreSearchResult> preList = new  ArrayList<PreSearchResult>();
			preList.add(new PreSearchResult(0,DBUserAPI.searchPreName(key)));
			preList.add(new PreSearchResult(1,DBVideoAPI.searchPreName(key)));
			preList.add(new PreSearchResult(2,DBCachedVideoAPI.searchPreName(key)));
		return preList;
	}
}
