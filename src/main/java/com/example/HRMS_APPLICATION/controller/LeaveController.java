package com.example.HRMS_APPLICATION.controller;

import com.example.HRMS_APPLICATION.model.LeaveRequest;
import com.example.HRMS_APPLICATION.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/requests")
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveService.getAllLeaveRequests();
    }

    @PostMapping("/requests")
    public LeaveRequest createLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        return leaveService.createLeaveRequest(leaveRequest);
    }
}
