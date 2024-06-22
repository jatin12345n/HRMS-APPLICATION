package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
