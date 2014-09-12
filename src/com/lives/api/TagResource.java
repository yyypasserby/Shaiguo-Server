/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.lives.model.Tag;

/**
 * @author yyypasserby
 *
 */
@Path("/tag")
public class TagResource {
	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<Tag> getTags(@PathParam("userId") int userId) {
		List<Tag> tags = new ArrayList<>();
		tags.add(new Tag(0, "晒果", "shaiguo.png", 100));
		tags.add(new Tag(1, "音乐", "music.png", 200));
		tags.add(new Tag(2, "体育", "sports.png", 300));
		tags.add(new Tag(3, "游戏", "games.png", 400));
		tags.add(new Tag(4, "在线教育", "moocs.png", 500));
		return tags;
	}
}
