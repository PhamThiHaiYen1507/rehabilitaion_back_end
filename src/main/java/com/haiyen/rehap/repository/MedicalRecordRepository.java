package com.haiyen.rehap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.MedicalReCord;

public interface MedicalRecordRepository extends JpaRepository<MedicalReCord, Integer> {
    @Query(value = "SELECT * FROM medical_records WHERE patient_id LIKE %?1% LIMIT 1", nativeQuery = true)
    MedicalReCord findByPatientId(int patientId);
}
