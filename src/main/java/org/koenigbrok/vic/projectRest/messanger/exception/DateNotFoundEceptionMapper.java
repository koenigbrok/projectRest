package org.koenigbrok.vic.projectRest.messanger.exception;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koenigbrok.vic.projectRest.messanger.model.ErrorMessage;



@Provider
public class DateNotFoundEceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
	
		ErrorMessage em = new ErrorMessage(exception.getMessage(), 404, "http://org.koenigbrok.org");

		return Response.status(Status.NOT_FOUND)
				.entity(em)
				.build();
		
	}

	
	
	
}
