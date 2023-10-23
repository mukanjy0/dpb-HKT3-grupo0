package com.example.sem11.professor.domain;

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
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastName;
    private String fullName;
    private String email;
    @OneToMany(mappedBy = "professor")
    Set<CourseAssessmentDetails> courseAssessmentDetails;
}
