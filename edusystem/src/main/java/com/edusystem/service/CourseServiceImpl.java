package com.edusystem.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.Course;
import com.edusystem.exception.CourseNotFoundException;
import com.edusystem.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		Course newCourse = courseRepository.save(course);
		return course;
	}

	@Override
	public Course getCourseById(int courseId) {
		
		logger.info("getCourseById method calling");

		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (optionalCourse.isEmpty()) {
			
			logger.error("coursenotfound exception");
			throw new CourseNotFoundException("Course Not existing with id: " + courseId);
		}

		Course course = optionalCourse.get();
		
		logger.info("getCourseById method returned");

		return course;
	}

	@Override
	public List<Course> getAllCourses() {

		List<Course> course = courseRepository.findAll();

		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		Optional<Course> optionalCourse = courseRepository.findById(course.getCourseId());

		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not found with id: " + course.getCourseId());
		}

		Course updatedCourse = courseRepository.save(course);

		return updatedCourse;
	}

	@Override
	public void deleteCourse(int courseId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);
		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not found with id: " + courseId);
		}

		courseRepository.deleteById(courseId);
	}

}
