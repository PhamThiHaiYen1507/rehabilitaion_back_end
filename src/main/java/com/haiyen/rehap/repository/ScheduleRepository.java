package com.haiyen.rehap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Query(value = "SELECT * FROM schedule WHERE patient_id LIKE %?1%", nativeQuery = true)
    List<Schedule> findByPatientId(int patientId);

    @Query(value = "SELECT * FROM schedule WHERE doctor_id LIKE %?1%", nativeQuery = true)
    List<Schedule> findByDoctorId(int doctorId);
}
