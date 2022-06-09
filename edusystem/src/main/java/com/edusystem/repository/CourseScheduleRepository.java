package com.edusystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edusystem.entity.CourseSchedule;

public interface CourseScheduleRepository extends JpaRepository<CourseSchedule, Integer> {

}
