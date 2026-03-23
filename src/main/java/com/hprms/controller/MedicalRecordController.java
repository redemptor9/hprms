package com.hprms.controller;

import com.hprms.model.MedicalRecord;
import com.hprms.service.MedicalRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/records")
public class MedicalRecordController {

    private final MedicalRecordService recordService;

    public MedicalRecordController(MedicalRecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<MedicalRecord>> getPatientHistory(@PathVariable String patientId) {
        try {
            List<MedicalRecord> records = recordService.getPatientHistory(patientId);
            return ResponseEntity.ok(records);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> addMedicalRecord(@RequestBody MedicalRecord record) {
        try {
            // Auto-generate some fields for convenience if not provided by frontend
            if (record.getRecordId() == null || record.getRecordId().isEmpty()) {
                record.setRecordId(UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            }
            if (record.getDateOfVisit() == null) {
                record.setDateOfVisit(LocalDateTime.now());
            }

            MedicalRecord createdRecord = recordService.addMedicalRecord(record);
            return ResponseEntity.ok(createdRecord);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
