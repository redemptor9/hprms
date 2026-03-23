package com.hprms.controller;

import com.hprms.model.Appointment;
import com.hprms.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping
    public ResponseEntity<Appointment> scheduleAppointment(@RequestBody Appointment appointment) {
        if (appointment.getAppointmentId() == null || appointment.getAppointmentId().isEmpty()) {
            appointment.setAppointmentId("APT" + UUID.randomUUID().toString().substring(0, 6).toUpperCase());
        }
        if (appointment.getStatus() == null || appointment.getStatus().isEmpty()) {
            appointment.setStatus("Scheduled");
        }
        
        Appointment created = appointmentService.scheduleAppointment(appointment);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Appointment>> getPatientAppointments(@PathVariable String patientId) {
        return ResponseEntity.ok(appointmentService.getPatientAppointments(patientId));
    }
    
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Appointment> updateStatus(@PathVariable String id, @RequestParam String status) {
        try {
            Appointment updated = appointmentService.updateStatus(id, status);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
