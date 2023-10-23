package com.example.sem11.course.application;

import com.example.sem11.course.domain.Course;
import com.example.sem11.course.domain.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseRepository repository;
    @GetMapping
    public ResponseEntity<List<Course>> read() {
        List<Course> courses = repository.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> read(@PathVariable Long id) {
        Optional<Course> course = repository.findById(id);
        return new ResponseEntity<>(course.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Course course) {
        repository.save(course);
        return ResponseEntity.status(201).body("Created course");
    }
}
