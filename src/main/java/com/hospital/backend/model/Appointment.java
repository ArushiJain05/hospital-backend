package com.hospital.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appointmentId;

    private int patientId;
    private int doctorId;
    private String appointmentDate;

    public Appointment() {
    }

    public Appointment(int patientId, int doctorId, String appointmentDate) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}