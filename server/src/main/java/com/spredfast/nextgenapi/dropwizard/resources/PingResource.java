package com.spredfast.nextgenapi.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {
	@GET
	@Timed
	public Response get() {
		return Response.ok("Pong").build();
	}
}
