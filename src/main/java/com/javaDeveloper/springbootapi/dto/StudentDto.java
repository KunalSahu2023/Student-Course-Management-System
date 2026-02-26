package com.javaDeveloper.springbootapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class StudentDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<String> roles;
    private Set<String> courses;

    public StudentDto() {}

    public StudentDto(Long id, String name, String email,
                      Set<String> roles, Set<String> courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roles = roles;
        this.courses = courses;
    }

    public StudentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
