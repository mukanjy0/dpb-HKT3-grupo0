package com.example.sem11.coursetype.application;

import com.example.sem11.course.domain.CourseRepository;
import com.example.sem11.coursetype.domain.CourseType;
import com.example.sem11.coursetype.domain.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_types")
public class CourseTypeController {
    @Autowired
    private CourseTypeRepository repository;
    @GetMapping
    public ResponseEntity<List<CourseType>> read() {
        List<CourseType> courseTypes = repository.findAll();
        return new ResponseEntity<>(courseTypes, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CourseType> read(@PathVariable Long id) {
        Optional<CourseType> course = repository.findById(id);
        return new ResponseEntity<>(course.get(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody CourseType courseType) {
        repository.save(courseType);
        return ResponseEntity.status(201).body("Created courseType");
    }
}
