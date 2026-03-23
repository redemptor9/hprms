package com.hprms.service;

import com.hprms.repository.PatientRepository;
import com.hprms.model.Patient;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient registerPatient(Patient patient) {
        if (patientRepository.existsById(patient.getPatientId())) {
            throw new IllegalArgumentException("A patient with this ID already exists.");
        }
        patientRepository.save(patient);
        return patient;
    }

    public Patient searchPatient(String patientId) {
        return patientRepository.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("No patient found with ID: " + patientId));
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient updatePatient(Patient patient) {
        if (!patientRepository.existsById(patient.getPatientId())) {
            throw new IllegalArgumentException("Patient not found for update.");
        }
        patientRepository.save(patient);
        return patient;
    }

    public boolean deletePatient(String patientId) {
        if (!patientRepository.existsById(patientId)) {
            throw new IllegalArgumentException("Patient not found for deletion.");
        }
        patientRepository.deleteById(patientId);
        return true;
    }
}
