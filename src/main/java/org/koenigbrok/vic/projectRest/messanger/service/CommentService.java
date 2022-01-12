package org.koenigbrok.vic.projectRest.messanger.service;

import java.util.*;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koenigbrok.vic.projectRest.messanger.database.DatabaseClass;
import org.koenigbrok.vic.projectRest.messanger.model.Comment;
import org.koenigbrok.vic.projectRest.messanger.model.ErrorMessage;
import org.koenigbrok.vic.projectRest.messanger.model.Message;



public class CommentService {


	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,  Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());	
	}
	
	public Comment getComment(long messageId, long commentId ) {
		
		ErrorMessage em = new ErrorMessage("fnf 404", 404, "http://org.koenigbrok.org");
		Response resp =  Response.status(Status.NOT_FOUND)
				.entity(em)
				.build();
		
		Message msg = messages.get(messageId);
		if(msg == null ) {
			throw new  WebApplicationException(resp);
		}
		Map<Long, Comment> comments = msg.getComments();
		Comment cmt =  comments.get(commentId);
		if(cmt == null) {
			throw new WebApplicationException(resp);
		}
		return cmt;
		
		
	}
	
	public Comment addComment(long messageId, Comment comment ) {
			Map<Long, Comment> comments = messages.get(messageId).getComments();
			comment.setId(comments.size() + 1);
			comments.put(comment.getId(), comment);
			return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		if(comment.getId() <=0) {
			return null;
		}
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId ) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}

}
