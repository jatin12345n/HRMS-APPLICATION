package com.example.hrms.application.repository;

import com.example.hrms.application.domain.Job;
import com.example.hrms.application.domain.Payslip;
import com.example.hrms.application.exception.DuplicatePayslipIdException;
import com.example.hrms.application.exception.PayslipDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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
        if (payslipMap.containsKey(payslipId)) {
            return payslipMap.get(payslipId);
        } else {
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

    @Override
    public Payslip updatePayroll(String payslipId, Map<String, Object> updates) {
        Payslip payslip = payslipMap.get(payslipId);
        if (payslip == null) {
            throw new PayslipDoesNotExistException("Payslip not found with id " + payslipId);
        }
        updates.forEach((key, value) -> {
            switch (key) {
                case "employeeName":
                    payslip.setEmployeeName((String) value);
                    break;
                case "amount":
                    payslip.setAmount((BigDecimal) value);
                    break;
            }
        });
        payslipMap.put(payslipId, payslip);
        return payslip;
    }

    @Override
    public void deletePayroll(String payslipId) {
        payslipMap.remove(payslipId);

    }
}
