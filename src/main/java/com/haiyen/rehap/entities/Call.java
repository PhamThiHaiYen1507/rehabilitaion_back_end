package com.haiyen.rehap.entities;

import java.sql.Time;
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
@Table(name = "call_record")
public class Call {

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

    @Column(name = "time")
    private Time time;

    @Column(name = "create_at")
    private Date createAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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

}