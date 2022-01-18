package org.koenigbrok.vic.projectRest.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;


import org.koenigbrok.vic.projectRest.messanger.model.Message;
import org.koenigbrok.vic.projectRest.messanger.service.messageService;

import com.sun.jersey.api.uri.UriTemplate;

@Path("/messageTestResource")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class messageTestResource {

	messageService ms = new messageService();
	
	 @GET 
	 @Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start, 
									@QueryParam("size") int size) {
		 System.out.println("json called");
		 if(year > 0) {
			 return ms.getAllMessagesByYear(year);
		 }
		 if(start >= 0 && size >= 0) {
			 return ms.getAllMessagesPaginated(start, size);
		 }
		return  ms.getAllMessages();
	}
	
	 
	// @POST
//		public Message  addMessage(Message message) {
//		return ms.addMessage(message);
//		}
	 
	 @POST
		public Response  addMessage(Message message, @Context UriInfo uriInfo) throws URISyntaxException {
	
		Message nm =  ms.addMessage(message);
		 String newId = String.valueOf(nm.getId());
		URI urll = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return	 Response.created(urll)
				.entity(nm)
				.build();
		}
	 
	 @GET
	 @Path("/{messageId}")
	 public Message getMessage(@PathParam("messageId")  long messageId, @Context UriInfo uriInfo) {
		  
		 Message message = ms.getMessage(messageId);	 
		 message.addLink(getUriForSelf(uriInfo, message), "self");
		 message.addLink(getUriForProfile(uriInfo, message), "profile"); 
		 message.addLink(getUriForComments(uriInfo, message), "comments"); 
		  
		  return message;
	}


	private String getUriForComments(UriInfo uriInfo, Message message) {
	
		URI uri = uriInfo.getBaseUriBuilder()
				.path(messageTestResource.class)
				.path(messageTestResource.class, "getCommentResource")
				.path(CommentResource.class)
				.replaceQueryParam("messageId", message.getId())
				.build();
		return uri.toString();
	}


	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri = uriInfo.getBaseUriBuilder()
				.path(ProfileResource.class)
				.path(message.getAuthor())
				.build();
		
		return uri.toString();
	}


	private String getUriForSelf(UriInfo uriInfo, Message message) {
		String uri = uriInfo.getBaseUriBuilder()
				 .path(messageTestResource.class)
				 .path(Long.toString(message.getId()))
				 .build()
				 .toString();
		return uri;
	}
	 
	 @PUT
	 @Path("/{messageId}")
	 public Message updateMessage(@PathParam("messageId")  long messageId, Message message) {
		  
		 message.setId(messageId);
		 
			return ms.updateMessage(message);
		}
	 
	 @DELETE
	 @Path("/{messageId}")
	 public void deleteMessage(@PathParam("messageId")  long messageId, Message message) {
		   
		 ms.removeMessage(messageId);
		}
	 
	 
	 
	 @Path("/{messageId}/comments")
	 public CommentResource getCommentResource() {
		 
		 return new CommentResource();
	 }
}
