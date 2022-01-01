package org.koenigbrok.vic.projectRest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class injectDemoResource {

	@GET
	@Path("anoations")
	public String getParamUsingAnnotation(@MatrixParam("param") String matrixparam,
											@HeaderParam("headerparam") String headerparam,
											@CookieParam("cookieparam") String cookieparam) {
		return "matrtrix param is " + matrixparam  + "header param is  "  + headerparam + "and also... cookieparam is:  " + cookieparam;
	}
	
}
