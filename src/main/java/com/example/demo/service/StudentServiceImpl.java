package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Objects.requireNonNull(id, "id must not be null");
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public Student saveStudent(Student student) {
        Objects.requireNonNull(student, "student must not be null");
        Student saved = repo.save(student);
        return Objects.requireNonNull(saved, "Saved student must not be null");
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Objects.requireNonNull(id, "id must not be null");
        return repo.findById(id)
                .map(existing -> {
                    // ensure the provided student has the correct id, then save
                    student.setId(id);
                    Student saved = repo.save(student);
                    return Objects.requireNonNull(saved, "Saved student must not be null");
                })
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    public void deleteStudent(Long id) {
        Objects.requireNonNull(id, "id must not be null");
        repo.deleteById(id);
    }
}