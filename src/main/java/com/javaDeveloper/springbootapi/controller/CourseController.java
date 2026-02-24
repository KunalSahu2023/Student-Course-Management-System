package com.javaDeveloper.springbootapi.controller;

import com.javaDeveloper.springbootapi.dto.CourseDto;
import com.javaDeveloper.springbootapi.model.Course;
import com.javaDeveloper.springbootapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // 🔹 Create Course
    @PostMapping
    public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    // 🔹 Get All Courses
    @GetMapping
    public ResponseEntity<List<CourseDto>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    // 🔹 Get Course By ID
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    // 🔹 Update Course
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> updateCourse(
            @PathVariable Long id,
            @RequestBody CourseDto course) {
        return ResponseEntity.ok(courseService.updateCourse(course,id));
    }

    // 🔹 Delete Course
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
