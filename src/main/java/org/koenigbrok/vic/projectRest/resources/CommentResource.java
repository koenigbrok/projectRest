package org.koenigbrok.vic.projectRest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koenigbrok.vic.projectRest.messanger.model.Comment;
import org.koenigbrok.vic.projectRest.messanger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	

	public CommentService cs = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId ){
		return cs.getAllComments(messageId);
	}
	

	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment) {
		return cs.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId, Comment comment) {
		comment.setId(commentId);
		return cs.updateComment(messageId, comment);
		
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId) {
		cs.removeComment(messageId, commentId);
	}
	
	
	
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId) {
		return cs.getComment(messageId, commentId);
	}
	
	
	
}
