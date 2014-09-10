package com.lives.api;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.CachedVideo;
import com.lives.model.Live;
import com.lives.model.User;
import com.lives.utils.DBCachedVideoAPI;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/search")
public class SearchResource {
	private DBUserAPI dbUser;
	private DBCachedVideoAPI dbCachedVideo;
	
	public SearchResource() throws SQLException{
		dbUser = new DBUserAPI();
		dbCachedVideo = new DBCachedVideoAPI();
	}
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public List<User> getUsersByName(@QueryParam("username") String username) throws SQLException {
		if(username == "null" || username == null) return null;
		return dbUser.searchUserByName(username);
	}

	@GET
	@Path("/live")
	@Produces("application/json")
	public List<Live> getLivesByName(@QueryParam("livename") String livename) {
		List<Live> lives = new ArrayList<>();
		lives.add(new Live(1,"DUODUO DOTA2 CASTING","cast1","12:00"));
		lives.add(new Live(2,"CANCAN LOL CASTING","cast2","18:00"));
		lives.add(new Live(3,"YANYAN ASSASSINATION CASTING","cast3","13:00"));
		lives.add(new Live(2,"CANCAN LOL CASTING","cast2","18:00"));
		lives.add(new Live(2,"CANCAN LOL CASTING","cast2","18:00"));
		lives.add(new Live(2,"CANCAN LOL CASTING","cast2","18:00"));
		return lives;
	}
	
	@GET
	@Path("/cached")
	@Produces("application/json")
	public List<CachedVideo> getCachedByName(@QueryParam("cachedname") String cachedname) throws NumberFormatException, SQLException, ParseException {
		if(cachedname == "" || cachedname == null) return null;
		return dbCachedVideo.searchCachedVideoByName(cachedname);
	}
}
