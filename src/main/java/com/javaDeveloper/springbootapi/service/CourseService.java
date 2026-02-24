package com.javaDeveloper.springbootapi.service;

import com.javaDeveloper.springbootapi.dto.CourseDto;

import java.util.List;

public interface CourseService {

    //create course
    CourseDto createCourse(CourseDto courseDto);

    //get all courses
    List<CourseDto> getAllCourses();

    //get course by id
    CourseDto getCourseById(Long id);

    //deletecourse
    void deleteCourse(Long id);

    //update course by id
    CourseDto updateCourse(CourseDto courseDto, Long id);
}