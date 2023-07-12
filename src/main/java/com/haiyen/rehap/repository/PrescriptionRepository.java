package com.haiyen.rehap.repository;

import com.haiyen.rehap.entities.Prescription;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {
    @Query(value = "SELECT * FROM prescription WHERE patient_id LIKE %?1% LIMIT 1", nativeQuery = true)
    Prescription findByPatientId(int patientId);
}
