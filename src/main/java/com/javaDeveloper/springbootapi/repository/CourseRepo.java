package com.javaDeveloper.springbootapi.repository;

import com.javaDeveloper.springbootapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseName(String courseName);
}
