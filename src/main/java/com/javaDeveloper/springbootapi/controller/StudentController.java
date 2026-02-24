package com.javaDeveloper.springbootapi.controller;

import com.javaDeveloper.springbootapi.dto.StudentDto;
import com.javaDeveloper.springbootapi.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // 🔹 Create Student
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }
    // 🔹 Get All Students
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // 🔹 Get Student By ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // 🔹 Update Student
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDto student) {
        return ResponseEntity.ok(studentService.updateStudent(student, id));
    }

    // 🔹 Delete Student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
