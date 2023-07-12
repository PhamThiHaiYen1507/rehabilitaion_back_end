package com.haiyen.rehap.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "medical_history")
public class MedicalHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "patient_id")
    private PatientsInfo patient;

    @ManyToOne
    @MapsId
    @JoinColumn(name = "doctor_id")
    private DoctorInfo doctor;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "fields")
    private String fields;

    @Column(name = "note")
    private String note;

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public DoctorInfo getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorInfo doctor) {
        this.doctor = doctor;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

}