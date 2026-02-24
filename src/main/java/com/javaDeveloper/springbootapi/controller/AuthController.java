package com.javaDeveloper.springbootapi.controller;

import com.javaDeveloper.springbootapi.dto.Login;
import com.javaDeveloper.springbootapi.dto.SignUp;
import com.javaDeveloper.springbootapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // 🔹 Register User
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUp signUp) {
        return ResponseEntity.ok(authService.register(signUp));
    }

    // 🔹 Login User
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Login login) {
        return ResponseEntity.ok(authService.login(login));
    }
}