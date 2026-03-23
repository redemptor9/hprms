package com.hprms.controller;

import com.hprms.model.LabTest;
import com.hprms.service.LabTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/labtests")
public class LabTestController {

    private final LabTestService labTestService;

    public LabTestController(LabTestService labTestService) {
        this.labTestService = labTestService;
    }

    @PostMapping
    public ResponseEntity<LabTest> addLabTest(@RequestBody LabTest test) {
        if (test.getTestId() == null || test.getTestId().isEmpty()) {
            test.setTestId("LAB" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }
        if (test.getDate() == null) {
            test.setDate(LocalDate.now());
        }
        
        LabTest created = labTestService.addLabTest(test);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<LabTest>> getPatientLabTests(@PathVariable String patientId) {
        return ResponseEntity.ok(labTestService.getPatientLabTests(patientId));
    }
    
    @GetMapping
    public ResponseEntity<List<LabTest>> getAllLabTests() {
        return ResponseEntity.ok(labTestService.getAllLabTests());
    }
}
