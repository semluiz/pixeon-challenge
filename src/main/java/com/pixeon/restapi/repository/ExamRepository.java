package com.pixeon.restapi.repository;

import com.pixeon.restapi.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {
}
