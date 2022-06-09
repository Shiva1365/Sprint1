package com.edusystem.service;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusystem.entity.TestEntity;
import com.edusystem.exception.TestNotFoundException;
import com.edusystem.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;

	@Override
	public TestEntity saveTest(TestEntity test) {
		test.setDate(LocalDate.now());
		TestEntity newTest = testRepository.save(test);
		return test;
	}

	@Override
	public TestEntity getTestById(int testId) {

		Optional<TestEntity> optionalTest = testRepository.findById(testId);

		if (optionalTest.isEmpty()) {
			throw new TestNotFoundException("Test Not existing with id: " + testId);
		}

		TestEntity test = optionalTest.get();

		return test;
	}

	@Override
	public List<TestEntity> getAllTests() {

		List<TestEntity> test = testRepository.findAll();

		return test;
	}

	@Override
	public TestEntity updateTest(TestEntity test) {
		Optional<TestEntity> optionalTest = testRepository.findById(test.getTestId());

		if (optionalTest.isEmpty()) {
			throw new TestNotFoundException("Test Not found with id: " + test.getTestId());
		}

		TestEntity updatedTest = testRepository.save(test);

		return updatedTest;
	}

	@Override
	public void deleteTest(int testId) {
		Optional<TestEntity> optionalTest = testRepository.findById(testId);
		if (optionalTest.isEmpty()) {
			throw new TestNotFoundException("Test Not found with id: " + testId);
		}

		testRepository.deleteById(testId);
	}

}
