package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.domain.LeaveRequest;
import com.example.hrms.application.exception.DuplicateLeaveRequestIdException;
import com.example.hrms.application.exception.LeaveRequestDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class LeaveRequestRepositoryInMemory implements LeaveRequestRepository {

    private final Map<String, LeaveRequest> leaveRequestMap = new ConcurrentHashMap<>();


    @Override
    public void createLeaveRequest(LeaveRequest leaveRequest) throws DuplicateLeaveRequestIdException {
        LeaveRequest previousLeaveRequest = leaveRequestMap.putIfAbsent(leaveRequest.getLeaveRequestId(), leaveRequest);
        if (previousLeaveRequest != null) {
            throw new DuplicateLeaveRequestIdException(
                    " LeaveRequest id " + leaveRequest.getLeaveRequestId() + "already exists");
        }
    }


    @Override
    public LeaveRequest getLeaveRequest(String leaveRequestId) {
        if (leaveRequestMap.containsKey(leaveRequestId)) {
            return leaveRequestMap.get(leaveRequestId);
        } else {
            throw new LeaveRequestDoesNotExistException("LeaveRequest is not found");
        }
    }


    @Override
    public List<LeaveRequest> findAllLeaveRequest() {
        return new ArrayList<>(leaveRequestMap.values());
    }

    @Override
    public void clearLeaveRequests() {
        leaveRequestMap.clear();
    }

    @Override
    public LeaveRequest updateLeave(String leaveRequestId, Map<String, Object> updates) {
        LeaveRequest leaveRequest=leaveRequestMap.get(leaveRequestId);
        if (leaveRequest==null){
            throw new LeaveRequestDoesNotExistException("LeaveRequest not found with id "+ leaveRequestId);
        }
        updates.forEach((key, value)->{
            switch (key){
                case "employeeName":
                    leaveRequest.setEmployeeName((String) value);
                    break;
                case "startDate":
                    leaveRequest.setStartDate((LocalDate) value);
                    break;
                case "endDate":
                    leaveRequest.setEndDate((LocalDate) value);
                    break;
            }
        });
        leaveRequestMap.put(leaveRequestId,leaveRequest);
        return leaveRequest;
    }

    @Override
    public void deleteLeave(String leaveRequestId) {
       leaveRequestMap.remove(leaveRequestId);
    }
}
