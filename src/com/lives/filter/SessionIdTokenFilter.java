package com.lives.filter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;

public class SessionIdTokenFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		// TODO Auto-generated method stub
		String access_token = context.getHeaderString("access_token");
		System.out.println(access_token);
		MultivaluedMap<String, String> headerMap = context.getHeaders();
		Set<String> ks = headerMap.keySet();
		for(String key : ks) {
		//	System.out.println(key + " : " + headerMap.get(key));
		}
		if(access_token != null && "hehe".compareTo(access_token) == 0) {
			System.out.println("Authenticated");
		}
		else {
			System.out.println("Not authenticated");
		}
	}

}
