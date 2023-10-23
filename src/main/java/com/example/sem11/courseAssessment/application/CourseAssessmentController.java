package com.example.sem11.courseAssessment.application;

import com.example.sem11.courseAssessment.domain.CourseAssessment;
import com.example.sem11.courseAssessment.domain.CourseAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_assessments")
public class CourseAssessmentController {
    @Autowired
    private CourseAssessmentRepository repository;
    @GetMapping
    public ResponseEntity<List<CourseAssessment>> read() {
        List<CourseAssessment> courseAssessments = repository.findAll();
        return new ResponseEntity<>(courseAssessments, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessment> read(@PathVariable Long id) {
        Optional<CourseAssessment> courseAssessment = repository.findById(id);
        return new ResponseEntity<>(courseAssessment.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CourseAssessment courseAssessment) {
        repository.save(courseAssessment);
        return ResponseEntity.status(201).body("Created courseAssessment");
    }
}
