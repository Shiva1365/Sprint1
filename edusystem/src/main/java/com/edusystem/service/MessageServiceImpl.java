package com.edusystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edusystem.entity.Message;
import com.edusystem.exception.MessageNotFoundException;
import com.edusystem.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public Message saveMessage(Message message) {
		message.setDateOfMsg(LocalDate.now());
		Message newMessage = messageRepository.save(message);
		return message;
	}

	@Override
	public Message getMessageById(int messageId) {
		Optional<Message> optionalMessage = messageRepository.findById(messageId);

		if (optionalMessage.isEmpty()) {
			throw new MessageNotFoundException("Message Not existing with id: " + messageId);
		}

		Message message = optionalMessage.get();

		return message;
	}

	@Override
	public List<Message> getAllMessages() {
		List<Message> message = messageRepository.findAll();

		return message;
	}

}
