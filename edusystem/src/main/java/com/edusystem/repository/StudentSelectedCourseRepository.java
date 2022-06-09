package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edusystem.entity.StudentSelectedCourse;

public interface StudentSelectedCourseRepository extends JpaRepository<StudentSelectedCourse, Integer> {

}
