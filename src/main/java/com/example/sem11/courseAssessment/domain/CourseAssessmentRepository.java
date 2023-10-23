package com.example.sem11.courseAssessment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssessmentRepository extends JpaRepository<CourseAssessment, Long> {
}
