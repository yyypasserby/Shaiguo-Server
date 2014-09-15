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
import com.lives.model.User;
import com.lives.utils.DBRelationAPI;
import com.lives.utils.DBUserAPI;

/**
 * @author yyypasserby
 * 
 *
 */
@Path("/friend")
public class FriendResource {

	@GET
	@Path("/{userId}")
	@Produces("application/json")
	public List<User> getUserFriend(@PathParam("userId") int userId) throws SQLException {
		List<User> friends = new ArrayList<>();
		List<Integer> friendsId = DBRelationAPI.queryRelationFrom(userId);
		int size = friendsId.size();
		System.out.println(size);
		for(int i=0;i<size;i++)
			friends.add(DBUserAPI.getUserById(friendsId.get(i)));
		return friends;
	}
}
