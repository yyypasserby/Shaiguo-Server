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

import com.lives.model.Live;

/**
 * @author yyypasserby
 *
 */
@Path("/live")
public class LiveResource {
	@GET
	@Produces("application/json")
	public List<Live> getLiveList() {
		List<Live> lives = new ArrayList<>();
		lives.add(new Live(1,"aa","images/cast1.jpg","12:00"));
		lives.add(new Live(2,"bb","images/cast2.jpg","13:00"));
		return lives;
	}
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Live getLiveById(@PathParam("id") int id) {
		return new Live(id,"cc","images/cast3.jpg","18:00");
	}
}
