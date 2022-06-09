package com.edusystem.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.edusystem.entity.StudentDetails;
import com.edusystem.entity.StudentSelectedCourse;
import com.edusystem.exception.StudentSelectedCourseNotFoundException;
import com.edusystem.repository.StudentDetailsRepository;
import com.edusystem.repository.StudentSelectedCourseRepository;

@SpringBootTest
public class StudentSelectedCourseServiceTest {

	@InjectMocks
	private StudentSelectedCourseService studentSelectedCourseService = new StudentSelectedCourseServiceImpl();

	@Mock
	private StudentSelectedCourseRepository studentSelectedCourseRepository;

	@Mock
	private StudentDetailsRepository studentDetailsRepository;

	@Test
	public void StudentSelectedCourseById() {

		StudentSelectedCourse studentSelectedCourse = new StudentSelectedCourse();

		studentSelectedCourse.setId(1);
		studentSelectedCourse.setJoiningdate(LocalDate.now());

		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = Optional.of(studentSelectedCourse);

		when(studentSelectedCourseRepository.findById(1)).thenReturn(optionalStudentSelectedCourse);

		StudentSelectedCourse myStudentSelectedCourse = studentSelectedCourseService.getStudentSelectedCourseById(1);

		assertEquals(LocalDate.now(), myStudentSelectedCourse.getJoiningdate());
	}

	@Test
	public void testGetStudentSelectedCourseByIdWithException() {

		when(studentSelectedCourseRepository.findById(100)).thenThrow(StudentSelectedCourseNotFoundException.class);

		assertThrows(StudentSelectedCourseNotFoundException.class,
				() -> studentSelectedCourseService.getStudentSelectedCourseById(100));
	}

	@Test
	public void testGetAllStudentSelectedCourse() {

		StudentSelectedCourse studentSelectedCourse = new StudentSelectedCourse();
		studentSelectedCourse.setId(1);
		studentSelectedCourse.setJoiningdate(LocalDate.now());

		StudentSelectedCourse studentSelectedCourse1 = new StudentSelectedCourse();
		studentSelectedCourse1.setId(2);
		studentSelectedCourse1.setJoiningdate(LocalDate.now());

		StudentSelectedCourse studentSelectedCourse2 = new StudentSelectedCourse();
		studentSelectedCourse2.setId(3);
		studentSelectedCourse2.setJoiningdate(LocalDate.now());

		List<StudentSelectedCourse> studentSelectedCourseList = new ArrayList<>();
		studentSelectedCourseList.add(studentSelectedCourse);
		studentSelectedCourseList.add(studentSelectedCourse1);
		studentSelectedCourseList.add(studentSelectedCourse2);

		when(studentSelectedCourseRepository.findAll()).thenReturn(studentSelectedCourseList);

		List<StudentSelectedCourse> studentSelectedCourses = studentSelectedCourseService
				.getAllStudentSelectedCourses();

		assertEquals(3, studentSelectedCourses.size());

	}

	@Test
	public void testSaveStudentSelectedCourse() {

		StudentDetails newStudentDetails = new StudentDetails();
		newStudentDetails.setStudentId(1);
		newStudentDetails.setStudentName("shiva");
		newStudentDetails.setStudentContact(634564);
		newStudentDetails.setStudentEmail("shiva@gmail.com");

		StudentSelectedCourse studentSelectedCourse = new StudentSelectedCourse();
		studentSelectedCourse.setId(10);
		studentSelectedCourse.setJoiningdate(LocalDate.now());
		studentSelectedCourse.setStudentDetails(newStudentDetails);

		when(studentDetailsRepository.findById(1)).thenReturn(Optional.of(newStudentDetails));

		when(studentSelectedCourseRepository.save(studentSelectedCourse)).thenReturn(studentSelectedCourse);

		StudentSelectedCourse newStudentSelectedCourse = studentSelectedCourseService
				.saveStudentSelectedCourse(studentSelectedCourse, 1);

		assertEquals(10, newStudentSelectedCourse.getId());
		assertEquals(1, newStudentDetails.getStudentId());

		verify(studentSelectedCourseRepository, times(1)).save(studentSelectedCourse);

	}

	@Test
	public void testDeleteCourse() {

		StudentSelectedCourse studentSelectedCourse = new StudentSelectedCourse();
		studentSelectedCourse.setId(1);
		studentSelectedCourse.setJoiningdate(LocalDate.now());

		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = Optional.of(studentSelectedCourse);

		when(studentSelectedCourseRepository.findById(1)).thenReturn(optionalStudentSelectedCourse);
		;

		studentSelectedCourseService.deleteStudentSelectedCourse(1);

		verify(studentSelectedCourseRepository, times(1)).findById(1);
		verify(studentSelectedCourseRepository, times(1)).deleteById(1);

	}

	@Test
	void testUpdateCourse() {

		StudentSelectedCourse studentSelectedCourse = new StudentSelectedCourse();
		studentSelectedCourse.setId(1);
		studentSelectedCourse.setJoiningdate(LocalDate.now());

		Optional<StudentSelectedCourse> optionalStudentSelectedCourse = Optional.of(studentSelectedCourse);

		when(studentSelectedCourseRepository.findById(1)).thenReturn(optionalStudentSelectedCourse);

		studentSelectedCourseService.updateStudentSelectedCourse(studentSelectedCourse);

		verify(studentSelectedCourseRepository, times(1)).findById(1);
		verify(studentSelectedCourseRepository, times(1)).save(studentSelectedCourse);

	}

}