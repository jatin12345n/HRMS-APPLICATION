package com.example.hrms.application.service;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.repository.LeaveRequestRepository;
import com.example.hrms.application.domain.LeaveRequest;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaveService {
    @Getter
    private final LeaveRequestRepository leaveRequestRepository;
    @Autowired
    public LeaveService(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }



    public void createLeaveRequest(LeaveRequest leaveRequest) {
         this.leaveRequestRepository.createLeaveRequest(leaveRequest);
    }

    public LeaveRequest getLeaveRequest(String leaveRequestId) {
        return this.leaveRequestRepository.getLeaveRequest(leaveRequestId);

    }
    public List<LeaveRequest> getAllLeaveRequests() {
        return this.leaveRequestRepository.findAllLeaveRequest();
    }

    public LeaveRequest updateLeave(String leaveRequestId, Map<String, Object> updates) {
        return this.leaveRequestRepository.updateLeave(leaveRequestId,updates);
    }

    public void deleteLeave(String leaveRequestId) {
        this.leaveRequestRepository.deleteLeave(leaveRequestId);
    }
}
