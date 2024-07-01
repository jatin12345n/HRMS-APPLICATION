package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.domain.LeaveRequest;

import java.util.List;
import java.util.Map;

public interface LeaveRequestRepository{

    void createLeaveRequest(LeaveRequest leaveRequest);

    LeaveRequest getLeaveRequest(String leaveRequestId);

    List<LeaveRequest> findAllLeaveRequest();

    void clearLeaveRequests();

    LeaveRequest updateLeave(String leaveRequestId, Map<String, Object> updates);

    void deleteLeave(String leaveRequestId);
}
