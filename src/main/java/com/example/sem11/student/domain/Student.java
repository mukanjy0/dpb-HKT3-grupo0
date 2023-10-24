package com.example.sem11.student.domain;

import com.example.sem11.courseAssessmentDetails.domain.CourseAssessmentDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String code;
    //private String area;
    @OneToMany(mappedBy = "student")
    Set<CourseAssessmentDetails> courseAssessmentDetails;
}
