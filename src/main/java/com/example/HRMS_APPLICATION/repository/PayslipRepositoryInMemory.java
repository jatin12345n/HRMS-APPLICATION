package com.example.HRMS_APPLICATION.repository;

import com.example.HRMS_APPLICATION.domain.Payslip;
import com.example.HRMS_APPLICATION.exception.DuplicatePayslipIdException;
import com.example.HRMS_APPLICATION.exception.PayslipDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PayslipRepositoryInMemory implements PayslipRepository {

    private final Map<String, Payslip> payslipMap = new ConcurrentHashMap<>();

    @Override
    public void createPayslip(Payslip payslip) throws DuplicatePayslipIdException {
        Payslip previousPayslip = payslipMap.putIfAbsent(payslip.getPayslipId(), payslip);
        if (previousPayslip != null) {
            throw new DuplicatePayslipIdException(
                    "Payslip id" + payslip.getPayslipId() + "already exists");
        }
    }

    @Override
    public Payslip getPayslip(String payslipId) {
        if (payslipMap.containsKey(payslipId)){
            return payslipMap.get(payslipId);
        }else {
            throw new PayslipDoesNotExistException("Payslip is not found");
        }
    }

    @Override
    public List<Payslip> findAllPayslip() {
        return new ArrayList<>(payslipMap.values());
    }

    @Override
    public void clearPayslips() {
    payslipMap.clear();
    }
}
