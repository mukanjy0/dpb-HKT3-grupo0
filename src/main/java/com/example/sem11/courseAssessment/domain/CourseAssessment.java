package com.example.sem11.courseAssessment.domain;

import com.example.sem11.course.domain.Course;
import com.example.sem11.courseAssessmentDetails.domain.CourseAssessmentDetails;
import com.example.sem11.periodo.domain.Periodo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String tipoNota;
    private String sumNota;
    private String nomenclatura;
    @ManyToOne(optional = false)
    Course course;
    @ManyToOne(optional = false)
    Periodo periodo;
    @OneToMany(mappedBy = "courseAssessment")
    Set<CourseAssessmentDetails> courseAssessmentDetails;
}
