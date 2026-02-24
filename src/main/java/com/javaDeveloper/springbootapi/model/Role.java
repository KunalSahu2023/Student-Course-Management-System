package com.javaDeveloper.springbootapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "roles")
    @Data
    public class Role {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(unique = true, nullable = false)
        private String roleName;  // ADMIN, STUDENT, TEACHER etc.

        @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
        private Set<UserRole> userRoles = new HashSet<>();

        public Role() {}

        public Role(String roleName) {
            this.roleName = roleName;
        }

    }
