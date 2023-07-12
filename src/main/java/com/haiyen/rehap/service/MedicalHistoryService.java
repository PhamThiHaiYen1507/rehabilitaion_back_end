package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.MedicalHistory;
import com.haiyen.rehap.repository.MedicalHistoryRepository;
import com.haiyen.rehap.result.Result;

@Service
public class MedicalHistoryService {
	@Autowired
	MedicalHistoryRepository medicalHistoryRepo;

	public Result findByPatientId(int patientId) {
		Result result = new Result();
		List<MedicalHistory> medicalHistoryList = medicalHistoryRepo.findByPatientId(patientId);
		if (medicalHistoryList.isEmpty()) {
			result.setMessage("Không có lịch sử khám bệnh");
		}
		result.setData(medicalHistoryList);
		return result;
	}

}
