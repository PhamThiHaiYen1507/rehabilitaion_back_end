package com.haiyen.rehap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer> {
    @Query(value = "SELECT * FROM medical_history WHERE patient_id LIKE %?1%", nativeQuery = true)
    List<MedicalHistory> findByPatientId(int patientId);
}
