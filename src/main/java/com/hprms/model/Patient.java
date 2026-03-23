package com.hprms.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private String patientId;

    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "contact_number")
    private String contactNumber;

    private String gender;

    public Patient() {}

    public Patient(String patientId, String name, LocalDate dateOfBirth, String contactNumber, String gender) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.gender = gender;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "ID='" + patientId + '\'' +
                ", Name='" + name + '\'' +
                ", DOB=" + dateOfBirth +
                ", Contact='" + contactNumber + '\'' +
                ", Gender='" + gender + '\'' +
                '}';
    }
}
