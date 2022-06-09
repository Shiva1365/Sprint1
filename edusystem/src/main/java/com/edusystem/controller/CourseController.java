package com.edusystem.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.edusystem.entity.Course;
import com.edusystem.service.CourseService;

@RestController
public class CourseController {
	
	Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;

	@PostMapping("/course/save")
	public ResponseEntity<Course> addCourse(@RequestBody Course course) {
		
		logger.info("endpoint: /course/save - method called");
	
		Course newCourse = courseService.saveCourse(course);
		ResponseEntity<Course> responseEntity = new ResponseEntity<>(newCourse, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/course/{courseId}")
	public ResponseEntity<Course> fetchCourseDetails(@PathVariable("courseId") int courseId) {

		Course course = courseService.getCourseById(courseId);
		ResponseEntity<Course> responseEntity = new ResponseEntity<>(course, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/course/all")
	public List<Course> fetchAllCourse() {

//		logger.info("endpoint: /course/all - method called");
		List<Course> courseList = courseService.getAllCourses();
		return courseList;
	}
	
		
//		logger.info("endpoint: /course/all - method called");

	@PutMapping("/course/update")
	public ResponseEntity<Course> modifyCourse(@RequestBody Course course) {

		Course updatedCourse = courseService.updateCourse(course);
		ResponseEntity<Course> responseEntity = new ResponseEntity<>(updatedCourse, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/course/delete/{courseId}")
	public ResponseEntity<String> removeCourse(@PathVariable("courseId") int courseId) {

		courseService.deleteCourse(courseId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Course Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

}
