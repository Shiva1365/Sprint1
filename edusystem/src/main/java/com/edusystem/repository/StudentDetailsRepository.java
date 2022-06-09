package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edusystem.entity.StudentDetails;

public interface StudentDetailsRepository extends JpaRepository<StudentDetails, Integer> {
	@Query("select s from StudentDetails s where s.studentId = :sid and s.studentPassword = :spwd")
	StudentDetails login(@Param("sid") int studentId, @Param("spwd") String studentPassword);

}
