/**
 * 
 */
package com.lives.config;

import org.glassfish.jersey.server.ResourceConfig;
import com.lives.api.Hello;
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
	}
}
