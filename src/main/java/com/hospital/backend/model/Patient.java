package com.hospital.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    private int patientId;

    private String name;
    private String disease;

    public Patient() {
    }

    public Patient(int patientId, String name, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}