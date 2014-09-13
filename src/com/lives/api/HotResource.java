/**
 * 
 */
package com.lives.api;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.lives.model.Live;
import com.lives.model.Tag;
import com.lives.model.User;
import com.lives.utils.DBTagAPI;
import com.lives.utils.DBUserAPI;
import com.lives.utils.DBVideoAPI;

/**
 * @author yyypasserby
 *
 */
@Path("/hot")
public class HotResource {
	@GET
	@Path("/category")
	@Produces("application/json")
	public List<Tag> getHotCategory() throws SQLException {
		return DBTagAPI.sortTags();
	}

	@GET
	@Path("/live")
	@Produces("application/json")
	public List<Live> getHotLive() throws NumberFormatException, SQLException, ParseException {
		return DBVideoAPI.sortVideo();
	}

	@GET
	@Path("/caster")
	@Produces("application/json")
	public List<User> getHotCaster() throws SQLException {

		return DBUserAPI.sortUsers();
	}
}
