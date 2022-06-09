package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
