package com.javaDeveloper.springbootapi.dto;

import lombok.Data;

@Data
public class Login {
    private String email;
    private String password;

    public Login() {}

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

