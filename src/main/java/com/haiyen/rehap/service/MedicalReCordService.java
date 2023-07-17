package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.MedicalReCord;
import com.haiyen.rehap.repository.MedicalRecordRepository;
import com.haiyen.rehap.result.Result;

@Service
public class MedicalReCordService {
	@Autowired
	MedicalRecordRepository medicalReCordRepo;

	public Result<List<MedicalReCord>> findAll() {
		Result<List<MedicalReCord>> result = new Result<List<MedicalReCord>>();
		result.setData(medicalReCordRepo.findAll());
		result.setMessage("Thành công");
		return result;
	}

	public Result<MedicalReCord> findByPatientId(int patientId) {
		Result<MedicalReCord> result = new Result<MedicalReCord>();
		MedicalReCord medicalReCord = medicalReCordRepo.findByPatientId(patientId);
		if (medicalReCord == null) {
			result.setMessage("Không tìm thấy hồ sơ bệnh án");
		}
		result.setData(medicalReCord);
		return result;
	}

}
