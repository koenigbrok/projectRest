package org.koenigbrok.vic.projectRest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/messageTestResource")
public class messageTestResource {

	
	 @GET 
	 @Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		return  "Oh hai!";
	}
}
