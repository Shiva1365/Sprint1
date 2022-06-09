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

import com.edusystem.entity.TestEntity;
import com.edusystem.service.TestService;

@RestController
public class TestController {
	@Autowired
	private TestService testService;

	@PostMapping("/test/save")
	public ResponseEntity<TestEntity> addCustomer(@RequestBody TestEntity test) {

		TestEntity newTest = testService.saveTest(test);
		ResponseEntity<TestEntity> responseEntity = new ResponseEntity<>(newTest, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/test/{testId}")
	public ResponseEntity<TestEntity> fetchTestDetails(@PathVariable("testId") int testId) {

		TestEntity test = testService.getTestById(testId);
		ResponseEntity<TestEntity> responseEntity = new ResponseEntity<>(test, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/test/all")
	public List<TestEntity> fetchAllTest() {

		List<TestEntity> testList = testService.getAllTests();
		return testList;
	}

	@PutMapping("/test/update")
	public ResponseEntity<TestEntity> modifyProduct(@RequestBody TestEntity teste) {

		TestEntity updatedTest = testService.updateTest(teste);
		ResponseEntity<TestEntity> responseEntity = new ResponseEntity<>(updatedTest, HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/test/delete/{testId}")
	public ResponseEntity<String> removeProduct(@PathVariable("testId") int testId) {

		testService.deleteTest(testId);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Test Deleted Successfully.", HttpStatus.OK);
		return responseEntity;
	}

}
