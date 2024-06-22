package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
}
