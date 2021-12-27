package org.koenigbrok.vic.projectRest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koenigbrok.vic.projectRest.messanger.model.Message;
import org.koenigbrok.vic.projectRest.messanger.service.messageService;

@Path("/messageTestResource")
public class messageTestResource {

	messageService ms = new messageService();
	
	 @GET 
	 @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage() {
		return  ms.getAllMessages();
	}
	 
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
		public Message  addMessage(Message message) {
		return ms.addMessage(message);
		}
	 
	 
	 @GET
	 @Path("/{messageId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Message getMessage(@PathParam("messageId")  long messageId) {
		  
		return ms.getMessage(messageId);
	}
	 
	 
}
