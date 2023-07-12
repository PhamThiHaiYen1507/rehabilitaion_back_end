package com.haiyen.rehap.entities;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "medical_records")
public class MedicalReCord {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "patient_id")
    private PatientsInfo patient;

    @Column(name = "hospitalized_day")
    private Date hospitalizedDay;

    @Column(name = "discharge_date")
    private Date dischargeDate;

    @Column(name = "diagnose_in")
    private String diagnoseIn;

    @Column(name = "diagnose_out")
    private String diagnoseOut;

    @Column(name = "test_result")
    private String testResult;

    @Column(name = "method")
    private String method;

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

    public Date getHospitalizedDay() {
        return hospitalizedDay;
    }

    public void setHospitalizedDay(Date hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDiagnoseIn() {
        return diagnoseIn;
    }

    public void setDiagnoseIn(String diagnoseIn) {
        this.diagnoseIn = diagnoseIn;
    }

    public String getDiagnoseOut() {
        return diagnoseOut;
    }

    public void setDiagnoseOut(String diagnoseOut) {
        this.diagnoseOut = diagnoseOut;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}