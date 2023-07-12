package com.haiyen.rehap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haiyen.rehap.entities.DoctorInfo;

public interface DoctorsRepository extends JpaRepository<DoctorInfo, Integer>{
	
}
