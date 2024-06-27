package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository{

    void createLeaveRequest(LeaveRequest leaveRequest);

    LeaveRequest getLeaveRequest(String leaveRequestId);

    List<LeaveRequest> findAllLeaveRequest();

    void clearLeaveRequests();
}
