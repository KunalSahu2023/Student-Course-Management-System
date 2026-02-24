package com.javaDeveloper.springbootapi.service.impl;

import com.javaDeveloper.springbootapi.dto.StudentDto;
import com.javaDeveloper.springbootapi.model.Student;
import com.javaDeveloper.springbootapi.repository.StudentRepo;
import com.javaDeveloper.springbootapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
    public class StudentServiceImpl implements StudentService {

        @Autowired
        private StudentRepo studentRepo;

        @Override
        public StudentDto getStudentById(Long id) {

            Student student = studentRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            return mapToDto(student);
        }

        @Override
        public List<StudentDto> getAllStudents() {
            return studentRepo.findAll()
                    .stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
        }

        @Override
        public StudentDto updateStudent(StudentDto dto, Long id) {

            Student student = studentRepo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Student not found"));

            student.setName(dto.getName());
            student.setEmail(dto.getEmail());

            studentRepo.save(student);

            return mapToDto(student);
        }

        @Override
        public void deleteStudent(Long id) {
            studentRepo.deleteById(id);
        }

        private StudentDto mapToDto(Student student) {
            return new StudentDto(
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    null,
                    null
            );
        }

    }
