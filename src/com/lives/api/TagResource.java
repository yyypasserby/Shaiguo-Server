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
	public List<Tag> getTags(@PathParam("userId") int userId) throws SQLException {
		List<Tag> tags = new ArrayList<>();
		List<Integer> tag = DBUserAPI.getUserById(userId).getTagList();
		for(int i=0;i<tag.size();)
			tags.add(DBTagAPI.getTagById(tag.get(i)));
		return tags;
	}
}
