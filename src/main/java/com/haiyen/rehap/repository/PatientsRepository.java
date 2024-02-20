package com.haiyen.rehap.repository;

import com.haiyen.rehap.entities.PatientsInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientsRepository extends JpaRepository<PatientsInfo, Integer> {
    @Query(value = "SELECT * FROM patients WHERE user_id = ?1 LIMIT 1", nativeQuery = true)
    PatientsInfo findByUserId(int userId);
}
