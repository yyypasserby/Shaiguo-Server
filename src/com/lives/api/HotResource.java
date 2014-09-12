/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lives.model.Live;
import com.lives.model.Tag;
import com.lives.model.User;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/hot")
public class HotResource {
	
	
	@GET
	@Path("/category")
	@Produces("application/json")
	public List<Tag> getHotCategory() {
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag(0, "浣撹偛", "football.png", 100));
		tags.add(new Tag(1, "娓告垙", "game.png", 200));
		return tags;
	}
	
	@GET
	@Path("/live")
	@Produces("application/json")
	public List<Live> getHotLive() {
		List<Live> lives = new ArrayList<>();
		lives.add(new Live(0, "LOL鐨勬纭墦寮�鏂瑰紡", "game.png", "13:00"));
		lives.add(new Live(1, "涓浗濂藉０闊� 姹嘲涓撳満", "chinavoice.png", "13:00"));
		return lives;
	}
	
	@GET
	@Path("/caster")
	@Produces("application/json")
	public List<User> getHotCaster() throws SQLException {
		List<User> users = new ArrayList<>();
		users.add(DBUserAPI.getUserById(400));
		users.add(DBUserAPI.getUserById(401));
		return users;
	}
}
