package com.edusystem.exception;

public class CourseScheduleNotFoundException extends RuntimeException {

	public CourseScheduleNotFoundException(String msg) {
		super(msg);
	}
}