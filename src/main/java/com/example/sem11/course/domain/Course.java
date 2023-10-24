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
@Setter @NoArgsConstructor @AllArgsConstructor
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCredits() {
        return credits;
    }

    public String getCode() {
        return code;
    }

    public String getHRGroup() {
        return HRGroup;
    }

    public String getVRGroup() {
        return VRGroup;
    }

    public Integer getCycle() {
        return cycle;
    }

    public CourseType getCourseType() {
        return courseType;
    }
}
