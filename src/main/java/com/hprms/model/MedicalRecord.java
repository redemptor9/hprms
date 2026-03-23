package com.hprms.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {
    @Id
    @Column(name = "record_id")
    private String recordId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "date_of_visit")
    private LocalDateTime dateOfVisit;

    private String diagnosis;
    private String prescription;

    public MedicalRecord() {}

    public MedicalRecord(String recordId, Patient patient, Doctor doctor, LocalDateTime dateOfVisit, String diagnosis, String prescription) {
        this.recordId = recordId;
        this.patient = patient;
        this.doctor = doctor;
        this.dateOfVisit = dateOfVisit;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public String getRecordId() { return recordId; }
    public void setRecordId(String recordId) { this.recordId = recordId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public LocalDateTime getDateOfVisit() { return dateOfVisit; }
    public void setDateOfVisit(LocalDateTime dateOfVisit) { this.dateOfVisit = dateOfVisit; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getPrescription() { return prescription; }
    public void setPrescription(String prescription) { this.prescription = prescription; }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "RecordID='" + recordId + '\'' +
                ", PatientID='" + (patient != null ? patient.getPatientId() : "null") + '\'' +
                ", DoctorID='" + (doctor != null ? doctor.getDoctorId() : "null") + '\'' +
                ", Date=" + dateOfVisit +
                ", Diagnosis='" + diagnosis + '\'' +
                ", Prescription='" + prescription + '\'' +
                '}';
    }
}
