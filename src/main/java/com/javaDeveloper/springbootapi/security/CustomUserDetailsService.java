package com.javaDeveloper.springbootapi.security;

import com.javaDeveloper.springbootapi.model.Student;
import com.javaDeveloper.springbootapi.repository.StudentRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final StudentRepo studentRepo;

    public CustomUserDetailsService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Student student = studentRepo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                student.getEmail(),
                student.getPassword(),
                student.getUserRoles()
                        .stream()
                        .map(role -> new SimpleGrantedAuthority(
                                role.getRole().getRoleName()))
                        .collect(Collectors.toList())
        );
    }
}
