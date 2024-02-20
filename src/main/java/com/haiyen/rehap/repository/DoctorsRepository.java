package com.haiyen.rehap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.DoctorInfo;

public interface DoctorsRepository extends JpaRepository<DoctorInfo, Integer> {
    @Query(value = "SELECT * FROM doctor WHERE user_id = ?1 LIMIT 1", nativeQuery = true)
    DoctorInfo findByUserId(int userId);
}
