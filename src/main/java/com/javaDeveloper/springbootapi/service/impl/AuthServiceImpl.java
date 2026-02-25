package com.javaDeveloper.springbootapi.service.impl;

import com.javaDeveloper.springbootapi.dto.Login;
import com.javaDeveloper.springbootapi.dto.SignUp;
import com.javaDeveloper.springbootapi.model.Student;
import com.javaDeveloper.springbootapi.repository.RoleRepo;
import com.javaDeveloper.springbootapi.repository.StudentRepo;
import com.javaDeveloper.springbootapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private RoleRepo roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String register(SignUp signUp) {

        Student student = new Student();
        student.setName(signUp.getName());
        student.setEmail(signUp.getEmail());
        student.setPassword(passwordEncoder.encode(signUp.getPassword()));

        studentRepo.save(student);

        return "User Registered Successfully";
    }

    @Override
    public String login(Login login) {

        Student student = studentRepo
                .findByEmail(login.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(login.getPassword(), student.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        return "Login Successful";
    }

}
