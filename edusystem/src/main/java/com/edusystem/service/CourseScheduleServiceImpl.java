package com.edusystem.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.Course;
import com.edusystem.entity.CourseSchedule;
import com.edusystem.entity.Trainer;
import com.edusystem.exception.CourseNotFoundException;
import com.edusystem.exception.CourseScheduleNotFoundException;
import com.edusystem.exception.TrainerNotFoundException;
import com.edusystem.repository.CourseRepository;
import com.edusystem.repository.CourseScheduleRepository;
import com.edusystem.repository.TrainerRepository;

@Service
public class CourseScheduleServiceImpl implements CourseScheduleService {

	@Autowired
	private CourseScheduleRepository courseScheduleRepository;
	
	@Autowired
	private TrainerRepository trainerRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseSchedule saveCourseSchedule(CourseSchedule courseSchedule,int courseId) {
		Optional<Course> optionalCourse = courseRepository.findById(courseId);

		if (optionalCourse.isEmpty()) {
			throw new CourseNotFoundException("Course Not existing with id: " + courseId);
		}
		
		Optional<Trainer> optionalTrainer = trainerRepository
				.findById(courseSchedule.getTrainerId());

		if (optionalTrainer.isEmpty()) {
			throw new TrainerNotFoundException(
					"Trainer Not found with id: " + courseSchedule.getTrainerId());
		}

		Course course = optionalCourse.get();
		courseSchedule.setCourse(course);

		CourseSchedule newCourseSchedule = courseScheduleRepository.save(courseSchedule);
		return newCourseSchedule;
	}

	@Override
	public CourseSchedule getCourseScheduleById(int courseScheduleId) {
		Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository.findById(courseScheduleId);

		if (optionalCourseSchedule.isEmpty()) {
			throw new CourseNotFoundException("Course Not existing with id: " + courseScheduleId);
		}

		CourseSchedule courseSchedule = optionalCourseSchedule.get();

		return courseSchedule;
	}

	@Override
	public List<CourseSchedule> getAllCourseSchedule() {

		List<CourseSchedule> courseSchedule = courseScheduleRepository.findAll();

		return courseSchedule;

	}

	@Override
	public CourseSchedule updateCourseSchedule(CourseSchedule courseSchedule) {

		Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository
				.findById(courseSchedule.getCourseScheduleId());

		if (optionalCourseSchedule.isEmpty()) {
			throw new CourseScheduleNotFoundException(
					"CourseSchedule Not found with id: " + courseSchedule.getCourseScheduleId());
		}
		
		Optional<Trainer> optionalTrainer = trainerRepository
				.findById(courseSchedule.getTrainerId());

		if (optionalTrainer.isEmpty()) {
			throw new TrainerNotFoundException(
					"Trainer Not found with id: " + courseSchedule.getTrainerId());
		}
		
		
		
		CourseSchedule courseSchedule1 = optionalCourseSchedule.get();
		Course course = courseSchedule1.getCourse();
		//course.setCourseSchedule(courseSchedule);
		courseSchedule.setCourse(course);

		CourseSchedule updatedCourseSchedule = courseScheduleRepository.save(courseSchedule);

		return updatedCourseSchedule;
	}

	@Override
	public void deleteCourseSchedule(int courseScheduleId) {

		Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository.findById(courseScheduleId);
		if (optionalCourseSchedule.isEmpty()) {
			throw new CourseScheduleNotFoundException("CourseSchedule Not found with id: " + courseScheduleId);
		}
		CourseSchedule courseSchedule = optionalCourseSchedule.get();
		Course course = courseSchedule.getCourse();
		course.setCourseSchedule(null);

		courseScheduleRepository.delete(optionalCourseSchedule.get());
	}

}