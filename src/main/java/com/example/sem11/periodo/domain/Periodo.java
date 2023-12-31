package com.example.sem11.periodo.domain;

import com.example.sem11.courseAssessment.domain.CourseAssessment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Setter @NoArgsConstructor @AllArgsConstructor
public class Periodo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String code;
    @OneToMany(mappedBy = "periodo")
    Set<CourseAssessment> courseAssessments;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
