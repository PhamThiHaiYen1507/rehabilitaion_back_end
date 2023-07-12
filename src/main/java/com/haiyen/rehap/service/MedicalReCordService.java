package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.MedicalReCord;
import com.haiyen.rehap.repository.MedicalRecordRepository;
import com.haiyen.rehap.result.Result;

@Service
public class MedicalReCordService {
	@Autowired
	MedicalRecordRepository medicalReCordRepo;

	public Result findAll() {
		Result result = new Result();
		result.setData(medicalReCordRepo.findAll());
		result.setMessage("Thành công");
		return result;
	}

	public Result findByPatientId(int patientId) {
		Result result = new Result();
		MedicalReCord medicalReCord = medicalReCordRepo.findByPatientId(patientId);
		if (medicalReCord == null) {
			result.setMessage("Không tìm thấy hồ sơ bệnh án");
		}
		result.setData(medicalReCord);
		return result;
	}

}
