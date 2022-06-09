package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.Message;

public interface MessageService {
	public Message saveMessage(Message message);

	public Message getMessageById(int messageId);

	public List<Message> getAllMessages();

}
