package com.javaDeveloper.springbootapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "students")
    @Data
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(unique = true, nullable = false)
        private String email;

        @ManyToMany(mappedBy = "students")
        private Set<Course> courses = new HashSet<>();

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
        private Set<UserRole> userRoles = new HashSet<>();

        // Constructors
        public Student() {}

        public Student(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }
