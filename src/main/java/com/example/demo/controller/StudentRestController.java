package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {

    private final StudentService service;

    public StudentRestController(StudentService service) {
        this.service = service;
    }

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // GET student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    // CREATE student
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // UPDATE student
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {

        Student existing = service.getStudentById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setCourse(student.getCourse());

        return service.saveStudent(existing);
    }

    // DELETE student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}