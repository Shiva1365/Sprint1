package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Integer> {

}
