package com.haiyen.rehap.repository;

import com.haiyen.rehap.entities.PatientsInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<PatientsInfo, Integer> {

}
