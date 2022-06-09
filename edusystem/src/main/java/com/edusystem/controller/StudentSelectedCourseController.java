package com.edusystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edusystem.entity.StudentSelectedCourse;
import com.edusystem.service.StudentSelectedCourseService;

@RestController
public class StudentSelectedCourseController {

	@Autowired
	private StudentSelectedCourseService studentselectedcourseService;

	@PostMapping("/studentselectedcourse/save/{studentId}")
	public ResponseEntity<StudentSelectedCourse> addStudentSelectedCourse(@PathVariable int studentId,
			@RequestBody StudentSelectedCourse studentselectedcourse) {

		StudentSelectedCourse newStudentSelectedCourse = studentselectedcourseService
				.saveStudentSelectedCourse(studentselectedcourse,studentId);
		ResponseEntity<StudentSelectedCourse> responseEntity = new ResponseEntity<>(newStudentSelectedCourse,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/studentselectedcourse/{studentselectedcourseId}")
	public ResponseEntity<StudentSelectedCourse> fetchStudentSelectedCourseDetails(
			@PathVariable("studentselectedcourseId") int studentselectedcourseId) {

		StudentSelectedCourse studentselectedcourse = studentselectedcourseService
				.getStudentSelectedCourseById(studentselectedcourseId);
		ResponseEntity<StudentSelectedCourse> responseEntity = new ResponseEntity<>(studentselectedcourse,
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/studentselectedcourse/all")
	public List<StudentSelectedCourse> fetchAllStudentSelectedCourse() {

		List<StudentSelectedCourse> studentselectedcourseList = studentselectedcourseService
				.getAllStudentSelectedCourses();
		return studentselectedcourseList;
	}

	@PutMapping("/studentselectedcourse/update")
	public ResponseEntity<StudentSelectedCourse> modifyProduct(
			@RequestBody StudentSelectedCourse studentselectedcourse) {

		StudentSelectedCourse updatedStudentSelectedCourse = studentselectedcourseService
				.updateStudentSelectedCourse(studentselectedcourse);
		ResponseEntity<StudentSelectedCourse> responseEntity = new ResponseEntity<>(updatedStudentSelectedCourse,
				HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/studentselectedcourse/delete/{studentselectedcourseId}")
	public ResponseEntity<String> removeProduct(@PathVariable("studentselectedcourseId") int studentselectedcourseId) {

		studentselectedcourseService.deleteStudentSelectedCourse(studentselectedcourseId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("StudentSelectedCourse Deleted Successfully.",
				HttpStatus.OK);
		return responseEntity;
	}

}
