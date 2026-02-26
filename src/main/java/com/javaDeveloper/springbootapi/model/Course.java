package com.javaDeveloper.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "courses")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String courseName;

        @ManyToMany(mappedBy = "courses")
        @JsonIgnore
        private Set<Student> students = new HashSet<>();

        public Course(String courseName) {
            this.courseName = courseName;
        }
    }
