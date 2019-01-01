package org.koushik.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.messenger.model.Message;

public class MessageService {
	
	public MessageService() {
		
	}

	public List<Message> getMessages() {
		
		List<Message> messageList = new ArrayList<>();
		messageList.add(new Message(1, "Hello World", "koushik"));
		messageList.add(new Message(2, "Hello 2019", "Bob"));
		return messageList;
	}
}
