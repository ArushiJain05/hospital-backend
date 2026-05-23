package com.hospital.backend.controller;

import com.hospital.backend.model.Appointment;
import com.hospital.backend.repository.AppointmentRepository;
import com.hospital.backend.repository.DoctorRepository;
import com.hospital.backend.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public AppointmentController(
            AppointmentRepository appointmentRepository,
            PatientRepository patientRepository,
            DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    @PostMapping
    public Object bookAppointment(@RequestBody Appointment appointment) {

        if (!patientRepository.existsById(appointment.getPatientId())) {
            return "Patient ID not found";
        }

        if (!doctorRepository.existsById(appointment.getDoctorId())) {
            return "Doctor ID not found";
        }

        return appointmentRepository.save(appointment);
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable int id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable int id) {
        appointmentRepository.deleteById(id);
        return "Appointment deleted successfully";
    }
}