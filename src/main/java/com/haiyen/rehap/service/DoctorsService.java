package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.repository.DoctorsRepository;
import com.haiyen.rehap.result.Result;

@Service
public class DoctorsService {
	@Autowired
	DoctorsRepository doctorRepo;

	public Result<List<DoctorInfo>> findAll() {
		Result<List<DoctorInfo>> result = new Result<List<DoctorInfo>>();
		result.setData(doctorRepo.findAll());
		result.setMessage("Thành công");
		return result;
	}

	public Result<DoctorInfo> findById(int id) {
		Result<DoctorInfo> result = new Result<DoctorInfo>();
		DoctorInfo doctor = doctorRepo.findById(id).orElse(null);
		if (doctor == null) {
			result.setMessage("Không tìm thấy bác sỹ");
		}
		result.setData(doctor);
		return result;
	}

}
