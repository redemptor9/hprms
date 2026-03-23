package com.hprms.service;

import com.hprms.repository.BillRepository;
import com.hprms.model.Bill;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    private final BillRepository billRepository;

    public BillingService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill createBill(Bill bill) {
        billRepository.save(bill);
        return bill;
    }

    public List<Bill> getPatientBills(String patientId) {
        return billRepository.findByPatientPatientId(patientId);
    }

    public Bill markAsPaid(String billId) {
        Bill bill = billRepository.findById(billId)
            .orElseThrow(() -> new IllegalArgumentException("Bill not found"));
        bill.setStatus("Paid");
        billRepository.save(bill);
        return bill;
    }
    
    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }
}
