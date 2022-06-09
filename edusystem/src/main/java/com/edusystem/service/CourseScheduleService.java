package com.edusystem.service;

import java.util.List;

import com.edusystem.entity.CourseSchedule;

public interface CourseScheduleService {

	public CourseSchedule saveCourseSchedule(CourseSchedule courseSchedule,int courseId);

	public CourseSchedule getCourseScheduleById(int courseScheduleId);

	public List<CourseSchedule> getAllCourseSchedule();

	public CourseSchedule updateCourseSchedule(CourseSchedule courseSchedule);

	public void deleteCourseSchedule(int courseScheduleId);
}