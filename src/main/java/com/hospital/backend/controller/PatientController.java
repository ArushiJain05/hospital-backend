package com.hospital.backend.controller;

import com.hospital.backend.model.Patient;
import com.hospital.backend.repository.PatientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable int id) {
        patientRepository.deleteById(id);
        return "Patient deleted successfully";
    }
}