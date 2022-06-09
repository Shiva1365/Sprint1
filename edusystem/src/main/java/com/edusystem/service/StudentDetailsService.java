package com.edusystem.service;

import java.util.List;
import com.edusystem.entity.StudentDetails;

public interface StudentDetailsService {

	public StudentDetails doLogin(int studentId, String studentPassword);

	public StudentDetails saveStudentDetails(StudentDetails studentDetails);

	public StudentDetails getStudentDetailsById(int studentId);

	public List<StudentDetails> getAllStudentDetails();

	public StudentDetails updateStudentDetails(StudentDetails studentDetails);

	public void deleteStudentDetails(int studentId);

}
