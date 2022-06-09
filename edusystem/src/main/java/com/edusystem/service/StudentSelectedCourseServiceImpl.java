package com.edusystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.CourseSchedule;
import com.edusystem.entity.StudentDetails;
import com.edusystem.entity.StudentSelectedCourse;
import com.edusystem.entity.TestEntity;
import com.edusystem.exception.CourseScheduleNotFoundException;
import com.edusystem.exception.StudentNotFoundException;
import com.edusystem.exception.StudentSelectedCourseNotFoundException;
import com.edusystem.exception.TestNotFoundException;
import com.edusystem.repository.CourseScheduleRepository;
import com.edusystem.repository.StudentDetailsRepository;
import com.edusystem.repository.StudentSelectedCourseRepository;
import com.edusystem.repository.TestRepository;

@Service
public class StudentSelectedCourseServiceImpl implements StudentSelectedCourseService {

	@Autowired
	private StudentSelectedCourseRepository studentselectedcourseRepository;

	@Autowired
	private StudentDetailsRepository studentDetailsRepository;

	@Autowired
	private CourseScheduleRepository courseScheduleRepository;

	@Autowired
	private TestRepository testRepository;

	@Override
	public StudentSelectedCourse saveStudentSelectedCourse(StudentSelectedCourse studentselectedcourse, int studentId) {
		studentselectedcourse.setJoiningdate(LocalDate.now());

		Optional<StudentDetails> optionalStudentDetails = studentDetailsRepository.findById(studentId);
		if (optionalStudentDetails.isEmpty()) {
			throw new StudentNotFoundException("Student Not existing with id: " + studentId);
		}

		Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository
				.findById(studentselectedcourse.getScheduleId());

		if (optionalCourseSchedule.isEmpty()) {
			throw new CourseScheduleNotFoundException(
					"CourseSchedule Not found with id: " + studentselectedcourse.getScheduleId());
		}

		Optional<TestEntity> optionalTestEntity = testRepository.findById(studentselectedcourse.getTestId());

		if (optionalTestEntity.isEmpty()) {
			throw new TestNotFoundException("Test Not found with id: " + studentselectedcourse.getTestId());
		}

		StudentDetails studentDetails = optionalStudentDetails.get();
		studentselectedcourse.setStudentDetails(studentDetails);

		StudentSelectedCourse newStudentSelectedCourse = studentselectedcourseRepository.save(studentselectedcourse);
		return newStudentSelectedCourse;
	}

	@Override
	public StudentSelectedCourse getStudentSelectedCourseById(int studentselectedcourseId) {

		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = studentselectedcourseRepository
				.findById(studentselectedcourseId);

		if (optionalStudentSelectedCourse.isEmpty()) {
			throw new StudentSelectedCourseNotFoundException(
					"StudentSelectedCourse Not existing with id: " + studentselectedcourseId);
		}

		StudentSelectedCourse studentselectedcourse = optionalStudentSelectedCourse.get();

		return studentselectedcourse;
	}

	@Override
	public List<StudentSelectedCourse> getAllStudentSelectedCourses() {

		List<StudentSelectedCourse> studentselectedcourse = studentselectedcourseRepository.findAll();

		return studentselectedcourse;
	}

	@Override
	public StudentSelectedCourse updateStudentSelectedCourse(StudentSelectedCourse studentselectedcourse) {
		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = studentselectedcourseRepository
				.findById(studentselectedcourse.getId());

		if (optionalStudentSelectedCourse.isEmpty()) {
			throw new StudentSelectedCourseNotFoundException(
					"StudentSelectedCourse Not found with id: " + studentselectedcourse.getId());
		}

		Optional<CourseSchedule> optionalCourseSchedule = courseScheduleRepository
				.findById(studentselectedcourse.getScheduleId());

		if (optionalCourseSchedule.isEmpty()) {
			throw new CourseScheduleNotFoundException(
					"CourseSchedule Not found with id: " + studentselectedcourse.getScheduleId());
		}

		Optional<TestEntity> optionalTestEntity = testRepository.findById(studentselectedcourse.getTestId());

		if (optionalTestEntity.isEmpty()) {
			throw new TestNotFoundException("Test Not found with id: " + studentselectedcourse.getTestId());
		}

		StudentSelectedCourse studentSelectedCourse1 = optionalStudentSelectedCourse.get();
		StudentDetails studentDetails = studentSelectedCourse1.getStudentDetails();
		studentselectedcourse.setStudentDetails(studentDetails);

		StudentSelectedCourse updatedStudentSelectedCourse = studentselectedcourseRepository
				.save(studentselectedcourse);

		return updatedStudentSelectedCourse;
	}

	@Override
	public void deleteStudentSelectedCourse(int studentselectedcourseId) {
		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = studentselectedcourseRepository
				.findById(studentselectedcourseId);
		if (optionalStudentSelectedCourse.isEmpty()) {
			throw new StudentSelectedCourseNotFoundException(
					"StudentSelectedCourse Not found with id: " + studentselectedcourseId);
		}

		studentselectedcourseRepository.deleteById(studentselectedcourseId);
	}

}
