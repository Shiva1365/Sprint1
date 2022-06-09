package com.edusystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.edusystem.entity.Message;
import com.edusystem.exception.MessageNotFoundException;
import com.edusystem.repository.MessageRepository;

@SpringBootTest
public class MessageServiceTest {

	@InjectMocks
	private MessageService messageService = new MessageServiceImpl();

	@Mock
	private MessageRepository messageRepository;

	@Test
	public void testMessageById() {

		Message message = new Message();
		message.setMessageId(1);
		message.setSubject("result");
		message.setText("pass");
		message.setDateOfMsg(LocalDate.now());

		Optional<Message> optionalMessage = Optional.of(message);

		when(messageRepository.findById(1)).thenReturn(optionalMessage);

		Message myMessage = messageService.getMessageById(1);

		assertEquals("pass", myMessage.getText());
	}

	@Test
	public void testGetMessageByIdWithException() {

		when(messageRepository.findById(1)).thenThrow(MessageNotFoundException.class);

		assertThrows(MessageNotFoundException.class, () -> messageService.getMessageById(1));
	}

	@Test
	public void testGetAllMessages() {

		Message message = new Message();
		message.setMessageId(1);
		message.setSubject("result");
		message.setText("pass");
		message.setDateOfMsg(LocalDate.now());

		Message message1 = new Message();
		message1.setMessageId(2);
		message1.setSubject("result");
		message1.setText("fail");
		message1.setDateOfMsg(LocalDate.now());

		List<Message> messageList = new ArrayList<>();
		messageList.add(message);
		messageList.add(message1);
		;

		when(messageRepository.findAll()).thenReturn(messageList);

		List<Message> messages = messageService.getAllMessages();

		assertEquals(2, messages.size());

	}

	@Test
	public void testSaveMessage() {

		Message message = new Message();
		message.setMessageId(1);
		message.setSubject("result");
		message.setText("pass");
		message.setDateOfMsg(LocalDate.now());

		when(messageRepository.save(message)).thenReturn(message);

		Message newMessage = messageService.saveMessage(message);

		assertEquals("result", newMessage.getSubject());

		verify(messageRepository, times(1)).save(message);

	}

}
