package com.example.sem11.courseAssessmentDetails.domain;

import com.example.sem11.courseAssessment.domain.CourseAssessment;
import com.example.sem11.professor.domain.Professor;
import com.example.sem11.student.domain.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CourseAssessmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String score;
    private String section;
    @ManyToOne(optional = false)
    Student student;
    @ManyToOne(optional = false)
    Professor professor;
    @ManyToOne
    CourseAssessment courseAssessment;
}
