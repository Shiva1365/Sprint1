package com.edusystem.service;

import java.util.List;
import com.edusystem.entity.TestEntity;

public interface TestService {
	public TestEntity saveTest(TestEntity test);

	public TestEntity getTestById(int testId);

	public List<TestEntity> getAllTests();

	public TestEntity updateTest(TestEntity test);

	public void deleteTest(int testId);

}