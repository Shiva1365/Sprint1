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

import com.edusystem.entity.CourseSchedule;
import com.edusystem.service.CourseScheduleService;

@RestController
public class CourseScheduleController {

	@Autowired
	private CourseScheduleService courseScheduleService;

	@PostMapping("/courseSchedule/save/{courseId}")
	public ResponseEntity<CourseSchedule> addCustomer(@PathVariable int courseId ,@RequestBody CourseSchedule courseSchedule) {

		CourseSchedule newCourseSchedule = courseScheduleService.saveCourseSchedule(courseSchedule,courseId);
		ResponseEntity<CourseSchedule> responseEntity = new ResponseEntity<>(newCourseSchedule, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/courseSchedule/{courseScheduleId}")
	public ResponseEntity<CourseSchedule> fetchCourseScheduleDetails(
			@PathVariable("courseScheduleId") int courseScheduleId) {

		CourseSchedule courseSchedule = courseScheduleService.getCourseScheduleById(courseScheduleId);
		ResponseEntity<CourseSchedule> responseEntity = new ResponseEntity<>(courseSchedule, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/courseSchedule/all")
	public List<CourseSchedule> fetchAllCourse() {

		List<CourseSchedule> courseScheduleList = courseScheduleService.getAllCourseSchedule();
		return courseScheduleList;
	}

	@PutMapping("/courseSchedule/update")
	public ResponseEntity<CourseSchedule> modifyProduct(@RequestBody CourseSchedule courseSchedule) {

		CourseSchedule updatedCourseSchedule = courseScheduleService.updateCourseSchedule(courseSchedule);
		ResponseEntity<CourseSchedule> responseEntity = new ResponseEntity<>(updatedCourseSchedule, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/courseSchedule/delete/{courseScheduleId}")
	public ResponseEntity<String> removeProduct(@PathVariable("courseScheduleId") int courseScheduleId) {

		courseScheduleService.deleteCourseSchedule(courseScheduleId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("CourseSchedule Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

}