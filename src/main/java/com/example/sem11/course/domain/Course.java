package com.example.sem11.course.domain;

import com.example.sem11.courseAssessment.domain.CourseAssessment;
import com.example.sem11.coursetype.domain.CourseType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.geom.Area;
import java.util.Set;

@Entity
@Table
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer credits;
    private String code;
    private String HRGroup;
    private String VRGroup;
    private Integer cycle;
//    private String area;
//    private String courseContent;
    @ManyToOne(optional = false)
    CourseType courseType;
    @OneToMany(mappedBy = "course")
    Set<CourseAssessment> courseAssessments;
}
