/**
 * 
 */
package com.lives.api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.lives.model.IndexImage;

/**
 * @author yyypasserby
 *
 */
@Path("/indexImage")
public class IndexImageResource {
	@GET
	@Produces("application/json")
	public List<IndexImage> getIndexImages() {
		List<IndexImage> indexImages = new ArrayList<>();
		indexImages.add(new IndexImage("back1"));
		indexImages.add(new IndexImage("back2"));
		indexImages.add(new IndexImage("back3"));
		return indexImages;
	}
}
