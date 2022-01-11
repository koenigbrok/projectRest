package org.koenigbrok.vic.projectRest.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.koenigbrok.vic.projectRest.messanger.database.DatabaseClass;
import org.koenigbrok.vic.projectRest.messanger.exception.DataNotFoundException;
import org.koenigbrok.vic.projectRest.messanger.model.Message;

import com.sun.xml.bind.marshaller.Messages;

public class messageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	

	public messageService() {
		messages.put(1L, new Message(1, "hii", "me"));
		messages.put(2L, new Message(2, "oh hai", "you"));
		messages.put(3L, new Message(3, "a simple hello would do, tvm", "them"));
	}

	public List<Message> getAllMessages(){
		
		return new ArrayList<Message>(messages.values());	
	}
	
	public List<Message> getAllMessagesByYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for(Message message : messages.values()) {
			if((cal.get(Calendar.YEAR)== year)){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;	
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if(start + size > list.size()) {
			return new ArrayList<Message>();
		}
		
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message message =  messages.get(id);
		if(message == null) {
			throw new DataNotFoundException("meessage with id  "  + id + "....is furcked");
		}
		return message;
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
		
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
