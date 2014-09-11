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
		tags.add(new Tag(0, "shaiguo", 100));
		tags.add(new Tag(1, "music", 200));
		tags.add(new Tag(2, "sports", 300));
		tags.add(new Tag(3, "games", 400));
		tags.add(new Tag(4, "moocs", 500));
		return tags;
	}
}
