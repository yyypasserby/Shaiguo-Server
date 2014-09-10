/**
 * 
 */
package com.lives.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.lives.api.AuthResource;
import com.lives.api.FriendResource;
import com.lives.api.Hello;
import com.lives.api.IndexImageResource;
import com.lives.api.MessageResource;
import com.lives.api.SearchResource;
import com.lives.api.UserResource;
import com.lives.filter.SessionIdTokenFilter;

import org.codehaus.jackson.jaxrs.*;;
/**
 * @author yyypasserby
 *
 */
public class APIApplication extends ResourceConfig {
	public APIApplication() {
		register(SessionIdTokenFilter.class);
		register(Hello.class);
		register(JacksonJsonProvider.class);
		register(UserResource.class);
		register(IndexImageResource.class);
		register(MessageResource.class);
		register(FriendResource.class);
		register(SearchResource.class);
		register(AuthResource.class);
		
	}
}
