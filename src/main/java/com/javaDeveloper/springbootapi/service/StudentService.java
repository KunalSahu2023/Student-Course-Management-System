package com.javaDeveloper.springbootapi.service;

import com.javaDeveloper.springbootapi.dto.StudentDto;
import com.javaDeveloper.springbootapi.dto.StudentResponse;
import com.javaDeveloper.springbootapi.model.Student;

import java.util.List;

public interface StudentService {

    // create student
    StudentResponse createStudent(StudentDto studentDto);

    // get student by id
    StudentResponse getStudentById(Long id);

    // get all students
    List<StudentResponse> getAllStudents();

    // update student
    StudentResponse updateStudent(StudentDto dto, Long id);

    // delete student
    void deleteStudent(Long id);
}
