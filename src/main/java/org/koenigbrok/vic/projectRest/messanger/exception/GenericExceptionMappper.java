package org.koenigbrok.vic.projectRest.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koenigbrok.vic.projectRest.messanger.model.ErrorMessage;

@Provider
public class GenericExceptionMappper implements ExceptionMapper<Throwable>{

	
	@Override
	public Response toResponse(Throwable throwable) {
	
		ErrorMessage em = new ErrorMessage(throwable.getMessage(), 500, "http://org.koenigbrok.org");

		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(em)
				.build();
		
	}
	
}
