package com.example.sem11.courseAssessmentDetails.application;

import com.example.sem11.courseAssessmentDetails.domain.CourseAssessmentDetails;
import com.example.sem11.courseAssessmentDetails.domain.CourseAssessmentDetailsRepository;
import com.example.sem11.courseAssessmentDetails.domain.CourseAssessmentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {
    @Autowired
    private CourseAssessmentDetailsService service;

    @GetMapping
    public ResponseEntity<List<CourseAssessmentDetails>> read() {
        return service.read();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> read(@PathVariable Long id){
        return service.read(id);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CourseAssessmentDetails courseAssessmentDetails) {
        return service.create(courseAssessmentDetails);
    }

    @PutMapping
    public ResponseEntity<String>  update(@RequestBody CourseAssessmentDetails courseAssessmentDetails) {
       return service.update(courseAssessmentDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
