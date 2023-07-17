package com.haiyen.rehap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.haiyen.rehap.entities.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer> {
    @Query(value = "SELECT * FROM chat_room WHERE patient_id = ?1", nativeQuery = true)
    List<ChatRoom> findByPatientId(int patientId);

    @Query(value = "SELECT * FROM chat_room WHERE doctor_id = ?1", nativeQuery = true)
    List<ChatRoom> findByDoctorId(int doctorId);
}
