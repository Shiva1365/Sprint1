package com.edusystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edusystem.entity.Message;
import com.edusystem.service.MessageService;

@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

	@PostMapping("/message/save")
	public ResponseEntity<Message> addMessage(@RequestBody Message message) {

		Message newMessage = messageService.saveMessage(message);
		ResponseEntity<Message> responseEntity = new ResponseEntity<>(newMessage, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/message/{messageId}")
	public ResponseEntity<Message> fetchMessageDetails(@PathVariable("messageId") int messageId) {

		Message message = messageService.getMessageById(messageId);
		ResponseEntity<Message> responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/message/all")
	public List<Message> fetchAllMessage() {

		List<Message> messageList = messageService.getAllMessages();
		return messageList;
	}

}
