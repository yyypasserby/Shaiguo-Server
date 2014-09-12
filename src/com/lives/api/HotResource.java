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
	
	private DBUserAPI userDB = null;
	
	public HotResource() {
		try {
			userDB = new DBUserAPI();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/category")
	@Produces("application/json")
	public List<Tag> getHotCategory() {
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag(0, "体育", "football.png", 100));
		tags.add(new Tag(1, "游戏", "game.png", 200));
		return tags;
	}
	
	@GET
	@Path("/live")
	@Produces("application/json")
	public List<Live> getHotLive() {
		List<Live> lives = new ArrayList<>();
		lives.add(new Live(0, "LOL的正确打开方式", "game.png", "13:00"));
		lives.add(new Live(1, "中国好声音 汪峰专场", "chinavoice.png", "13:00"));
		return lives;
	}
	
	@GET
	@Path("/caster")
	@Produces("application/json")
	public List<User> getHotCaster() throws SQLException {
		List<User> users = new ArrayList<>();
		users.add(userDB.getUserById(400));
		users.add(userDB.getUserById(401));
		return users;
	}
}
