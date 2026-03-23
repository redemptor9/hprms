package com.hprms.service;

import com.hprms.repository.MedicalRecordRepository;
import com.hprms.repository.PatientRepository;
import com.hprms.model.MedicalRecord;
import com.hprms.model.Patient;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository recordRepository;
    private final PatientRepository patientRepository;

    public MedicalRecordService(MedicalRecordRepository recordRepository, PatientRepository patientRepository) {
        this.recordRepository = recordRepository;
        this.patientRepository = patientRepository;
    }

    public MedicalRecord addMedicalRecord(MedicalRecord record) {
        String patientId = record.getPatient() != null ? record.getPatient().getPatientId() : null;
        if (patientId == null || !patientRepository.existsById(patientId)) {
            throw new IllegalArgumentException("Cannot add record. Patient ID does not exist.");
        }
        recordRepository.save(record);
        return record;
    }

    public List<MedicalRecord> getPatientHistory(String patientId) {
        if (!patientRepository.existsById(patientId)) {
            throw new IllegalArgumentException("Patient ID does not exist.");
        }
        return recordRepository.findByPatientPatientId(patientId);
    }
}
