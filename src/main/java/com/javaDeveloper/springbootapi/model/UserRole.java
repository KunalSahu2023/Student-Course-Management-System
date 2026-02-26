package com.javaDeveloper.springbootapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_roles",
        uniqueConstraints = @UniqueConstraint(columnNames = {"student_id", "role_id"}))
@Getter
@Setter
@AllArgsConstructor
    public class UserRole {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "student_id", nullable = false)
        private Student student;

        @ManyToOne
        @JoinColumn(name = "role_id", nullable = false)
        private Role role;

        public UserRole() {}

        public UserRole(Student student, Role role) {
            this.student = student;
            this.role = role;
        }

    }