package com.example.sem11.student.application;

import com.example.sem11.professor.domain.ProfessorRepository;
import com.example.sem11.student.domain.Student;
import com.example.sem11.student.domain.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentRepository repository;
    @GetMapping
    public ResponseEntity<List<Student>> read() {
        List<Student> students = repository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> read(@PathVariable Long id) {
        Optional<Student> student = repository.findById(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Student student) {
        repository.save(student);
        return ResponseEntity.status(201).body("Created student");
    }
}
