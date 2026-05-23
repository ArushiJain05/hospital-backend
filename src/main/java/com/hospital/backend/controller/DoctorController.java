package com.hospital.backend.controller;

import com.hospital.backend.model.Doctor;
import com.hospital.backend.repository.DoctorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable int id) {
        return doctorRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable int id) {
        doctorRepository.deleteById(id);
        return "Doctor deleted successfully";
    }
}