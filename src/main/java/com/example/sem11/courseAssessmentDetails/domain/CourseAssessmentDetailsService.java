package com.example.sem11.courseAssessmentDetails.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseAssessmentDetailsService {
    @Autowired
    private CourseAssessmentDetailsRepository repository;

    public CourseAssessmentDetails updateCourseAssessmentDetailsRepository(CourseAssessmentDetails toUpdate) {
        Long id = toUpdate.getId();
        CourseAssessmentDetails original =  repository.getReferenceById(id);
        if (toUpdate.getId() != null) original.setId(toUpdate.getId());
        if (toUpdate.getScore() != null) original.setScore(toUpdate.getScore());
        if (toUpdate.getSection() != null) original.setSection(toUpdate.getSection());
        if (toUpdate.getStudent() != null) original.setStudent(toUpdate.getStudent());
        if (toUpdate.getProfessor() != null) original.setProfessor(toUpdate.getProfessor());
        if (toUpdate.getCourseAssessment() != null) original.setCourseAssessment(toUpdate.getCourseAssessment());

        repository.save(original);

        return original;
    }

    public ResponseEntity<List<CourseAssessmentDetails>> read() {
        List<CourseAssessmentDetails> cads = repository.findAll();
        return new ResponseEntity<>(cads, HttpStatus.OK);
    }
    public ResponseEntity<CourseAssessmentDetails> read(Long id) {
        Optional<CourseAssessmentDetails> optionalCAD = repository.findById(id);
        if(optionalCAD.isPresent()) {
            return new ResponseEntity<>(optionalCAD.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> create(CourseAssessmentDetails courseAssessmentDetails) {
        repository.save(courseAssessmentDetails);
        return ResponseEntity.status(201).body("Created Course Assessment Details");
    }

    public ResponseEntity<String>  update(CourseAssessmentDetails courseAssessmentDetails) {
        updateCourseAssessmentDetailsRepository(courseAssessmentDetails);
        return ResponseEntity.status(200).body("Updated course assessment details");
    }

    public ResponseEntity<String> delete(Long id) {
        Optional<CourseAssessmentDetails> optionalCAD = repository.findById(id);
        if (optionalCAD.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.status(200).body("Deleted");
        } else {
            return ResponseEntity.status(404).body("Not Found");
        }
    }
}
