package com.hprms.model;

import javax.persistence.*;

@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private String doctorId;

    private String name;
    private String specialization;

    public Doctor() {}

    public Doctor(String doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "ID='" + doctorId + '\'' +
                ", Name='" + name + '\'' +
                ", Specialization='" + specialization + '\'' +
                '}';
    }
}
