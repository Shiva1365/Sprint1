package com.edusystem.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message_table")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id")
	private int messageId;

	@Column(name = "message_subject")
	private String subject;

	@Column(name = "message_text")
	private String text;

	@Column(name = "message_date")
	private LocalDate dateOfMsg;

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDateOfMsg() {
		return dateOfMsg;
	}

	public void setDateOfMsg(LocalDate dateOfMsg) {
		this.dateOfMsg = dateOfMsg;
	}

}
