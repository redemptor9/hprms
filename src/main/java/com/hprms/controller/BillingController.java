package com.hprms.controller;

import com.hprms.model.Bill;
import com.hprms.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @PostMapping
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill) {
        if (bill.getBillId() == null || bill.getBillId().isEmpty()) {
            bill.setBillId("INV" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }
        if (bill.getDate() == null) {
            bill.setDate(LocalDate.now());
        }
        if (bill.getStatus() == null || bill.getStatus().isEmpty()) {
            bill.setStatus("Unpaid");
        }
        
        Bill created = billingService.createBill(bill);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Bill>> getPatientBills(@PathVariable String patientId) {
        return ResponseEntity.ok(billingService.getPatientBills(patientId));
    }
    
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billingService.getAllBills());
    }

    @PatchMapping("/{id}/pay")
    public ResponseEntity<Bill> markAsPaid(@PathVariable String id) {
        try {
            Bill updated = billingService.markAsPaid(id);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
