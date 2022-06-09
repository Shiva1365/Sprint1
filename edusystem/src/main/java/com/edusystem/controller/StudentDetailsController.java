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

import com.edusystem.entity.StudentDetails;
import com.edusystem.model.StudentLoginRequest;
import com.edusystem.model.StudentLoginResponse;
import com.edusystem.service.StudentDetailsService;

@RestController
public class StudentDetailsController {

	@Autowired
	private StudentDetailsService studentDetailsService;

	@PostMapping("/studentDetails/save")
	public ResponseEntity<StudentDetails> addCustomer(@RequestBody StudentDetails studentDetails) {

		StudentDetails newStudentDetails = studentDetailsService.saveStudentDetails(studentDetails);
		ResponseEntity<StudentDetails> responseEntity = new ResponseEntity<>(newStudentDetails, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/studentDetails/{studentId}")
	public ResponseEntity<StudentDetails> fetchStudentDetails(@PathVariable("studentId") int studentId) {

		StudentDetails studentDetails = studentDetailsService.getStudentDetailsById(studentId);
		ResponseEntity<StudentDetails> responseEntity = new ResponseEntity<>(studentDetails, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/studentDetails/all")
	public List<StudentDetails> fetchAllStudentDetails() {

		List<StudentDetails> studentDetailsList = studentDetailsService.getAllStudentDetails();
		return studentDetailsList;
	}

	@PutMapping("/studentDetails/update")
	public ResponseEntity<StudentDetails> modifyProduct(@RequestBody StudentDetails studentDetails) {

		StudentDetails updatedstudentDetails = studentDetailsService.updateStudentDetails(studentDetails);
		ResponseEntity<StudentDetails> responseEntity = new ResponseEntity<>(updatedstudentDetails, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/studentDetails/delete/{studentDetailsId}")
	public ResponseEntity<String> removeProduct(@PathVariable("studentDetailsId") int studentDetailsId) {

		studentDetailsService.deleteStudentDetails(studentDetailsId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("StudentDetails Deleted Successfully.",
				HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping("/studentDetails/login")
	public ResponseEntity<StudentLoginResponse> singin(@RequestBody StudentLoginRequest loginReq) {

		StudentDetails studentDetails = studentDetailsService.doLogin(loginReq.getStudentId(),
				loginReq.getStudentPassword());

		StudentLoginResponse loginResp = new StudentLoginResponse();

		loginResp.setStudentId(studentDetails.getStudentId());
		loginResp.setStudentName(studentDetails.getStudentName());
		loginResp.setStudentContact(studentDetails.getStudentContact());
		loginResp.setStudentEmail(studentDetails.getStudentEmail());
		loginResp.setGender(studentDetails.getGender());
		loginResp.setStudentAddress(studentDetails.getStudentAddress());
		ResponseEntity<StudentLoginResponse> responseEntity = new ResponseEntity<>(loginResp, HttpStatus.OK);
		return responseEntity;
	}

}