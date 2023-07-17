package com.haiyen.rehap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.Call;

public interface CallRepository extends JpaRepository<Call, Integer> {
    @Query(value = "SELECT * FROM call_record WHERE patient_id = ?1", nativeQuery = true)
    List<Call> findByPatientId(int patientId);

    @Query(value = "SELECT * FROM call_record WHERE doctor_id = ?1", nativeQuery = true)
    List<Call> findByDoctorId(int doctorId);
}
