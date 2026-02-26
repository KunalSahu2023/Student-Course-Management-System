package com.javaDeveloper.springbootapi.dto;

import java.util.Set;

public class StudentResponse {
        private Long id;
        private String name;
        private String email;

        public StudentResponse(Long id, String name, String email, Set<String> roles, Set<String> courses) {
        }
}
