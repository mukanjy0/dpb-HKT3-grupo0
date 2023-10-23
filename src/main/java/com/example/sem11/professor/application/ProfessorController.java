package com.example.sem11.professor.application;

import com.example.sem11.professor.domain.Professor;
import com.example.sem11.professor.domain.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
public class ProfessorController {
    @Autowired
    private ProfessorRepository repository;
    @GetMapping
    public ResponseEntity<List<Professor>> read() {
        List<Professor> professors = repository.findAll();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Professor> read(@PathVariable Long id) {
        Optional<Professor> professor = repository.findById(id);
        return new ResponseEntity<>(professor.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Professor professor) {
        repository.save(professor);
        return ResponseEntity.status(201).body("Created professor");
    }
}
