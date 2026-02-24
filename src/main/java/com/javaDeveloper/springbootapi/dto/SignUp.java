package com.javaDeveloper.springbootapi.dto;

import lombok.Data;

import java.util.Set;

@Data
public class SignUp {
    private String name;
    private String email;
    private String password;
    private Set<String> roles;  // ADMIN, STUDENT etc.

    public SignUp() {}

    public SignUp(String name, String email, String password, Set<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
