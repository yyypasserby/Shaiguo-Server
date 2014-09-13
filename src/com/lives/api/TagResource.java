/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lives.model.Tag;
import com.lives.utils.DBTagAPI;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/tag")
public class TagResource {
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public String getTags(@PathParam("userId") int userId) throws SQLException {
//		List<Tag> tags = new ArrayList<>();
//		tags.add(new Tag(0, "晒果", "shaiguo.png", 100));
//		tags.add(new Tag(1, "音乐", "music.png", 200));
//		tags.add(new Tag(2, "体育", "sports.png", 300));
//		tags.add(new Tag(3, "游戏", "games.png", 400));
		String tags=DBUserAPI.getUserById(userId).getTags();
		return tags;
	}
}
