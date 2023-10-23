package com.example.sem11.courseAssessmentDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseAssessmentDetailsRepository extends JpaRepository<CourseAssessmentDetails, Long> {
}
