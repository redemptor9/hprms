package com.hprms.service;

import com.hprms.repository.PatientRepository;
import com.hprms.repository.MedicalRecordRepository;
import com.hprms.repository.BillRepository;
import com.hprms.model.Bill;
import com.hprms.model.MedicalRecord;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final PatientRepository patientRepository;
    private final MedicalRecordRepository recordRepository;
    private final BillRepository billRepository;

    public ReportService(PatientRepository patientRepository, MedicalRecordRepository recordRepository, BillRepository billRepository) {
        this.patientRepository = patientRepository;
        this.recordRepository = recordRepository;
        this.billRepository = billRepository;
    }

    public Map<String, Object> getHospitalStatistics() {
        Map<String, Object> stats = new HashMap<>();
        
        // Total Patients
        long totalPatients = patientRepository.count();
        stats.put("totalPatients", totalPatients);
        
        // Total Treatments/Records
        List<MedicalRecord> allRecords = recordRepository.findAll();
        stats.put("totalTreatments", allRecords.size());
        
        // Today's Visits (Records added today)
        LocalDate today = LocalDate.now();
        long visitsToday = allRecords.stream()
                .filter(r -> r.getDateOfVisit() != null && r.getDateOfVisit().toLocalDate().isEqual(today))
                .count();
        stats.put("visitsToday", visitsToday);
        
        // Financials
        List<Bill> allBills = billRepository.findAll();
        BigDecimal totalRevenue = allBills.stream()
                .filter(b -> "Paid".equals(b.getStatus()))
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        stats.put("totalRevenue", totalRevenue);
        
        BigDecimal pendingRevenue = allBills.stream()
                .filter(b -> "Unpaid".equals(b.getStatus()))
                .map(Bill::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        stats.put("pendingRevenue", pendingRevenue);

        return stats;
    }
}
