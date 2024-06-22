package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
