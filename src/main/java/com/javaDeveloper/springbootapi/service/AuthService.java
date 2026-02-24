package com.javaDeveloper.springbootapi.service;

import com.javaDeveloper.springbootapi.dto.Login;
import com.javaDeveloper.springbootapi.dto.SignUp;

public interface AuthService {

    //login
    String login(Login login);

    //register
    String register(SignUp signup);
}