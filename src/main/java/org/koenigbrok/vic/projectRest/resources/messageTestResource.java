package org.koenigbrok.vic.projectRest.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koenigbrok.vic.projectRest.messanger.model.Message;
import org.koenigbrok.vic.projectRest.messanger.service.messageService;

@Path("/messageTestResource")
public class messageTestResource {

	messageService ms = new messageService();
	
	 @GET 
	 @Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessage() {
		return  ms.getAllMessages();
	}
}
