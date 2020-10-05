package com.m2i.helloworld.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("hellorest")
public class HelloWorldResource {
	@GET
	@Produces("text/plain")
	public String getHello() {
		return "Hello";
	}
	
}
