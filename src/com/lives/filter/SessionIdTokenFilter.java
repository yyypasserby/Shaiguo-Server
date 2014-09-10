package com.lives.filter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class SessionIdTokenFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		// TODO Auto-generated method stub
		MultivaluedMap<String, String> headerMap = context.getHeaders();
		List<String> listHeaders = headerMap.get("access-control-request-headers");
		
//		String access_token = context.getHeaderString("access_token");
//		System.out.println(access_token);
		Set<String> ks = headerMap.keySet();
		for(String key : ks) {
			System.out.println(key + " : " + headerMap.get(key));
		}
		if(listHeaders.contains("hehe")) {
			System.out.println("Authenticated");
		}
		else {
			System.out.println("Not authenticated");
			context.abortWith(Response
                    .status(Response.Status.UNAUTHORIZED)
                    .entity("User cannot access the resource.")
                    .build());
		}
	}

}
