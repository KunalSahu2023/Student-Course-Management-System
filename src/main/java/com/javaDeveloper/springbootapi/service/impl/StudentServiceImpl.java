package com.javaDeveloper.springbootapi.service.impl;
import com.javaDeveloper.springbootapi.dto.StudentDto;
import com.javaDeveloper.springbootapi.dto.StudentResponse;
import com.javaDeveloper.springbootapi.model.Course;
import com.javaDeveloper.springbootapi.model.Role;
import com.javaDeveloper.springbootapi.model.Student;
import com.javaDeveloper.springbootapi.model.UserRole;
import com.javaDeveloper.springbootapi.model.enums.RoleType;
import com.javaDeveloper.springbootapi.repository.CourseRepo;
import com.javaDeveloper.springbootapi.repository.RoleRepo;
import com.javaDeveloper.springbootapi.repository.StudentRepo;
import com.javaDeveloper.springbootapi.service.StudentService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final CourseRepo courseRepo;

    public StudentServiceImpl(StudentRepo studentRepo,
                              PasswordEncoder passwordEncoder,
                              RoleRepo roleRepo,
                              CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public StudentResponse createStudent(StudentDto studentDto) {

        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setPassword(passwordEncoder.encode(studentDto.getPassword()));

        // ✅ ROLE MAPPING (FIXED)
        Set<UserRole> userRoles = new HashSet<>();

        for (String roleName : studentDto.getRoles()) {

            RoleType roleType = RoleType.valueOf(roleName.toUpperCase());

            Role role = roleRepo.findByName(roleType)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));

            UserRole userRole = new UserRole();
            userRole.setStudent(student);
            userRole.setRole(role);

            userRoles.add(userRole);
        }

        student.setUserRoles(userRoles);

        // ✅ COURSE MAPPING
        Set<Course> courses = new HashSet<>();

        for (String courseName : studentDto.getCourses()) {

            Course course = courseRepo.findByCourseName(courseName)
                    .orElseThrow(() -> new RuntimeException("Course not found: " + courseName));

            courses.add(course);
        }

        student.setCourses(courses);

        Student savedStudent = studentRepo.save(student);

        return mapToDto(savedStudent);
    }

    @Override
    public StudentResponse getStudentById(Long id) {

        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return mapToDto(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentRepo.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse updateStudent(StudentDto dto, Long id) {

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

    // ✅ FIXED DTO MAPPING
    private StudentResponse mapToDto(Student student) {

        Set<String> roles = student.getUserRoles()
                .stream()
                .map(userRole -> userRole.getRole().getName().name())
                .collect(Collectors.toSet());

        Set<String> courses = student.getCourses()
                .stream()
                .map(Course::getCourseName)
                .collect(Collectors.toSet());

        return new StudentResponse(
                student.getId(),
                student.getName(),
                student.getEmail(),
                roles,
                courses
        );
    }
}