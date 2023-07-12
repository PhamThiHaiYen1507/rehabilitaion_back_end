package com.haiyen.rehap.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientsInfo patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorInfo doctor;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // @JsonIgnore
    public PatientsInfo getPatient() {
        return patient;
    }

    public void setPatient(PatientsInfo patient) {
        this.patient = patient;
    }

    public DoctorInfo getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorInfo doctor) {
        this.doctor = doctor;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}