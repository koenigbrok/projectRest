package org.koenigbrok.vic.projectRest.messanger.service;

import java.util.ArrayList;
import java.util.List;

import org.koenigbrok.vic.projectRest.messanger.model.Message;

public class messageService {

	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "hi wurld", "vic");
		Message m2 = new Message(2L, "hi Mush", "vOc");
		Message m3 = new Message(3L, "hi jersey", "vAc");
		
		List<Message> list = new ArrayList<Message>();
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		return list;
		
		
	}
}
