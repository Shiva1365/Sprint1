package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.StudentSelectedCourse;

public interface StudentSelectedCourseService {

	public StudentSelectedCourse saveStudentSelectedCourse(StudentSelectedCourse studentselectedcourse,int studentId);

	public StudentSelectedCourse getStudentSelectedCourseById(int studentselectedcourseId);

	public List<StudentSelectedCourse> getAllStudentSelectedCourses();

	public StudentSelectedCourse updateStudentSelectedCourse(StudentSelectedCourse studentselectedcourse);

	public void deleteStudentSelectedCourse(int studentselectedcourseId);

}