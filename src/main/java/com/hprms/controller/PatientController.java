package com.hprms.controller;

import com.hprms.model.Patient;
import com.hprms.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        try {
            Patient patient = patientService.searchPatient(id);
            return ResponseEntity.ok(patient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Patient> registerPatient(@RequestBody Patient patient) {
        try {
            Patient createdPatient = patientService.registerPatient(patient);
            return ResponseEntity.ok(createdPatient);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
