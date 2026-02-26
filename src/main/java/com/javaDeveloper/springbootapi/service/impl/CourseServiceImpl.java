package com.javaDeveloper.springbootapi.service.impl;

import com.javaDeveloper.springbootapi.dto.CourseDto;
import com.javaDeveloper.springbootapi.model.Course;
import com.javaDeveloper.springbootapi.repository.CourseRepo;
import com.javaDeveloper.springbootapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public CourseDto createCourse(CourseDto course) {

        Course course1 = new Course();
        course1.setCourseName(course.getCourseName());

        courseRepo.save(course1);

        return new CourseDto(course1.getId(), course1.getCourseName(), null);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return courseRepo.findAll()
                .stream()
                .map(course -> new CourseDto(
                        course.getId(),
                        course.getCourseName(),
                        null
                ))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto getCourseById(Long id) {

        Course course = courseRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return new CourseDto(
                course.getId(),
                course.getCourseName(),
                null
        );
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public CourseDto updateCourse(CourseDto courseDto, Long id) {
        return null;
    }

}