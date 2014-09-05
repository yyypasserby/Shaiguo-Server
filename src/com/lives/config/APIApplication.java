/**
 * 
 */
package com.lives.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.lives.api.FriendResource;
import com.lives.api.Hello;
import com.lives.api.IndexImageResource;
import com.lives.api.MessageResource;
import com.lives.api.SearchResource;
import com.lives.api.UserResource;

import org.codehaus.jackson.jaxrs.*;;
/**
 * @author yyypasserby
 *
 */
public class APIApplication extends ResourceConfig {
	public APIApplication() {
		register(Hello.class);
		register(JacksonJsonProvider.class);
		register(UserResource.class);
		register(IndexImageResource.class);
		register(MessageResource.class);
		register(FriendResource.class);
		register(SearchResource.class);
	}
}
