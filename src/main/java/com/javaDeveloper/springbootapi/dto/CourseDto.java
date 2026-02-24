package com.javaDeveloper.springbootapi.dto;

import lombok.Data;
import java.util.Set;

@Data
public class CourseDto {
    private Long id;
    private String courseName;
    private Set<String> students;  // Only student names or emails

    public CourseDto() {}

    public CourseDto(Long id, String courseName, Set<String> students) {
        this.id = id;
        this.courseName = courseName;
        this.students = students;
    }

    }
