package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.Course;

public interface CourseService {

	public Course saveCourse(Course course);

	public Course getCourseById(int courseId);

	public List<Course> getAllCourses();

	public Course updateCourse(Course course);

	public void deleteCourse(int courseId);
}
