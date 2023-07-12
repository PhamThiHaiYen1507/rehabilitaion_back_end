package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.repository.DoctorsRepository;
import com.haiyen.rehap.result.DoctorsResult;

@Service
public class DoctorsService {
	@Autowired
	DoctorsRepository doctorRepo;

	public DoctorsResult findAll() {
		DoctorsResult result = new DoctorsResult();
		result.setData(doctorRepo.findAll());
		result.setMessage("Thành công");
		return result;
	}

	public DoctorsResult findById(int id) {
		DoctorsResult result = new DoctorsResult();
		DoctorInfo doctor = doctorRepo.findById(id).orElse(null);
		if (doctor == null) {
			result.setMessage("Không tìm thấy bác sỹ");
		}
		result.setData(doctor);
		return result;
	}

}
