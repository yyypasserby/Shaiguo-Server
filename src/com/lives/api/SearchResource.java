package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.lives.model.CachedVideo;
import com.lives.model.Live;
import com.lives.model.User;

/**
 * @author yyypasserby
 *
 */
@Path("/search")
public class SearchResource {
	
	@GET
	@Path("/user")
	@Produces("application/json")
	public List<User> getUsersByName(@QueryParam("username") String username) {
		List<User> users = new ArrayList<>();
		users.add(new User(1,"DUDU", "dudu@shaiguo.com", 0));
		users.add(new User(2,"YANYAN", "yanyan@shaiguo.com", 1));
		users.add(new User(3,"DUODUO", "duoduo@shaiguo.com", 2));
		return users;
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
	public List<CachedVideo> getCachedByName(@QueryParam("cachedname") String cachedname) {
		List<CachedVideo> lives = new ArrayList<>();
		lives.add(new CachedVideo(1,0,"DUODUO PREVIEW","",1000));
		lives.add(new CachedVideo(2,0,"YANYAN PREVIEW","",2000));
		lives.add(new CachedVideo(3,1,"DUDU PREVIEW","",3000));
		lives.add(new CachedVideo(4,1,"YAOYAO PREVIEW","",4000));
		lives.add(new CachedVideo(5,2,"FRANK PREVIEW","",5000));
		lives.add(new CachedVideo(6,3,"CANCAN PREVIEW","",6000));
		return lives;
	}
}
