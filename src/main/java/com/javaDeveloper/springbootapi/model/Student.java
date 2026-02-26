package com.javaDeveloper.springbootapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "students")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        private String password;

        @ManyToMany
        @JoinTable(
                name = "student_course",
                joinColumns = @JoinColumn(name = "student_id"),
                inverseJoinColumns = @JoinColumn(name = "course_id")
        )
        private Set<Course> courses = new HashSet<>();

        @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
        @JsonIgnore
        private Set<UserRole> userRoles = new HashSet<>();

        public Student(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }
    }
