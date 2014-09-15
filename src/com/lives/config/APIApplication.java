/**
 * 
 */
package com.lives.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import com.lives.api.ActionResource;
import com.lives.api.AuthResource;
import com.lives.api.CastResource;
import com.lives.api.FMSResource;
import com.lives.api.FriendResource;
import com.lives.api.Hello;
import com.lives.api.HotResource;
import com.lives.api.IndexImageResource;
import com.lives.api.MessageResource;
import com.lives.api.SearchResource;
import com.lives.api.SubscribeResource;
import com.lives.api.TagResource;
import com.lives.api.UserResource;
import com.lives.api.VideoResource;
import com.lives.filter.SessionIdTokenFilter;

import org.codehaus.jackson.jaxrs.*;;
/**
 * @author yyypasserby
 *
 */
public class APIApplication extends ResourceConfig {
	public APIApplication() {
		//register(SessionIdTokenFilter.class);
		register(Hello.class);
		register(JacksonJsonProvider.class);
		register(UserResource.class);
		register(IndexImageResource.class);
		register(MessageResource.class);
		register(FriendResource.class);
		register(SearchResource.class);
		register(AuthResource.class);
		register(TagResource.class);
		register(SubscribeResource.class);
		register(HotResource.class);
		register(FMSResource.class);
		register(ActionResource.class);
		register(CastResource.class);
		register(VideoResource.class);
	}
}
