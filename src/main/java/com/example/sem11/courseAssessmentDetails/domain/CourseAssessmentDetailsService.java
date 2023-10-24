package com.example.sem11.courseAssessmentDetails.domain;

import com.example.sem11.courseAssessment.domain.CourseAssessment;
import com.example.sem11.courseAssessment.domain.CourseAssessmentRepository;
import com.example.sem11.professor.domain.Professor;
import com.example.sem11.professor.domain.ProfessorRepository;
import com.example.sem11.student.domain.Student;
import com.example.sem11.student.domain.StudentRepository;
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
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ProfessorRepository professorRepository;
    @Autowired
    private CourseAssessmentRepository courseAssessmentRepository;

    public CourseAssessmentDetails updateCourseAssessmentDetailsRepository(CourseAssessmentDetails toUpdate) {
        Long id = toUpdate.getId();
        CourseAssessmentDetails original =  repository.getReferenceById(id);
        if (toUpdate.getId() != null) original.setId(toUpdate.getId());
        if (toUpdate.getScore() != null) original.setScore(toUpdate.getScore());
        if (toUpdate.getSection() != null) original.setSection(toUpdate.getSection());
        if (toUpdate.getStudent() != null) {
            Optional<Student> student = studentRepository.findById(toUpdate.getStudent().getId());
            if (student.isPresent()) original.setStudent(student.get());
            else return null;
        }
        if (toUpdate.getProfessor() != null) {
            Optional<Professor> professor = professorRepository.findById(toUpdate.getProfessor().getId());
            if (professor.isPresent()) original.setProfessor(professor.get());
            else return null;
        }
        if (toUpdate.getCourseAssessment() != null) {
            Optional<CourseAssessment> courseAssessment = courseAssessmentRepository.findById(toUpdate.getCourseAssessment().getId());
            if (courseAssessment.isPresent()) original.setCourseAssessment(courseAssessment.get());
            else return null;
        }

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
        Optional<Student> student = studentRepository.findById(courseAssessmentDetails.getStudent().getId());
        Optional<Professor> professor = professorRepository.findById(courseAssessmentDetails.getProfessor().getId());
        Optional<CourseAssessment> courseAssessment = courseAssessmentRepository.findById(courseAssessmentDetails.getCourseAssessment().getId());

        if (!student.isPresent()) {
            return ResponseEntity.status(400).body("No student with such id.");
        }
        else courseAssessmentDetails.setStudent(student.get());
        if  (!professor.isPresent()) {
            return ResponseEntity.status(400).body("No professor with such id.");
        }
        else courseAssessmentDetails.setProfessor(professor.get());
        if  (!courseAssessment.isPresent()) {
            return ResponseEntity.status(400).body("No course assessment with such id.");
        }
        else courseAssessmentDetails.setCourseAssessment(courseAssessment.get());

        repository.save(courseAssessmentDetails);
        return ResponseEntity.status(201).body("Created Course Assessment Details");
    }

    public ResponseEntity<String>  update(CourseAssessmentDetails courseAssessmentDetails) {
        courseAssessmentDetails = updateCourseAssessmentDetailsRepository(courseAssessmentDetails);
        if (courseAssessmentDetails != null) return ResponseEntity.status(200).body("Updated course assessment details");
        else return ResponseEntity.status(400).body("Bad request");
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
