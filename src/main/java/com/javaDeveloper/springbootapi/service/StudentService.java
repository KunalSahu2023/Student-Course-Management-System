package com.javaDeveloper.springbootapi.service;

import com.javaDeveloper.springbootapi.dto.StudentDto;

import java.util.List;

public interface StudentService {

    // create student
    StudentDto createStudent(StudentDto studentDto);

    // get student by id
    StudentDto getStudentById(Long id);

    // get all students
    List<StudentDto> getAllStudents();

    // update student
    StudentDto updateStudent(StudentDto dto, Long id);

    // delete student
    void deleteStudent(Long id);
}
