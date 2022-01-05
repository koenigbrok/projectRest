package org.koenigbrok.vic.projectRest.messanger.service;

import java.util.*;



import org.koenigbrok.vic.projectRest.messanger.database.DatabaseClass;
import org.koenigbrok.vic.projectRest.messanger.model.Comment;
import org.koenigbrok.vic.projectRest.messanger.model.Message;

public class CommentService {


	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long,  Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());	
	}
	
	public Comment getComment(long messageId, long commentId ) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
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
