package com.hprms.service;

import com.hprms.repository.AppointmentRepository;
import com.hprms.repository.PatientRepository;
import com.hprms.repository.DoctorRepository;
import com.hprms.model.Appointment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment scheduleAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> getPatientAppointments(String patientId) {
        return appointmentRepository.findByPatientPatientId(patientId);
    }

    public Appointment updateStatus(String appointmentId, String status) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
            .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
        return appointment;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
}
