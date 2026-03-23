package com.hprms.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lab_tests")
public class LabTest {
    @Id
    @Column(name = "test_id")
    private String testId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "test_name")
    private String testName;

    private String result;

    @Column(name = "test_date")
    private LocalDate date;

    public LabTest() {}

    public LabTest(String testId, Patient patient, Doctor doctor, String testName, String result, LocalDate date) {
        this.testId = testId;
        this.patient = patient;
        this.doctor = doctor;
        this.testName = testName;
        this.result = result;
        this.date = date;
    }

    public String getTestId() { return testId; }
    public void setTestId(String testId) { this.testId = testId; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
