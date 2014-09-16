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

import com.lives.api.helper.Result;
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
	@Produces("application/json")
	public List<Tag> getTags() throws SQLException {
		return DBTagAPI.allTags();
    }
}
