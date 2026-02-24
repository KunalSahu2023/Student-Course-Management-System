package com.javaDeveloper.springbootapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "courses")
    @Data
    public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String courseName;

        @ManyToMany
        @JoinTable(
                name = "student_course",
                joinColumns = @JoinColumn(name = "course_id"),
                inverseJoinColumns = @JoinColumn(name = "student_id")
        )
        private Set<Student> students = new HashSet<>();

        public Course() {}

        public Course(String courseName) {
            this.courseName = courseName;
        }
    }
