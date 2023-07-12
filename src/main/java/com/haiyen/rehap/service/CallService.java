package com.haiyen.rehap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.Call;
import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.repository.CallRepository;
import com.haiyen.rehap.repository.DoctorsRepository;
import com.haiyen.rehap.repository.PatientsRepository;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.result.Result.Status;

@Service
public class CallService {
	@Autowired
	CallRepository callRepo;

	@Autowired
	DoctorsRepository doctorsRepository;

	@Autowired
	PatientsRepository patientsRepository;

	public Result findByPatientId(int patientId) {
		Result result = new Result();
		List<Call> callList = callRepo.findByPatientId(patientId);
		if (callList.isEmpty()) {
			result.setMessage("Không có cuộc gọi");
		}
		result.setData(callList);
		return result;
	}

	public Result findByDoctorId(int doctorId) {
		Result result = new Result();
		List<Call> callList = callRepo.findByDoctorId(doctorId);
		if (callList.isEmpty()) {
			result.setMessage("Không có cuộc gọi");
		}
		result.setData(callList);
		return result;
	}

	public Result create(Call call) {
		Result result = new Result();
		// Lấy doctorId từ body request
		int doctorId = call.getDoctor().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		DoctorInfo doctor = doctorsRepository.findById(doctorId).orElse(null);
		if (doctor == null) {
			result.setMessage("Bác sĩ không tồn tại");
			return result;
		}
		call.setDoctor(doctor);// Lấy patientId từ body request
		int patientId = call.getPatient().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		PatientsInfo patient = patientsRepository.findById(patientId).orElse(null);
		if (patient == null) {
			result.setMessage("Bệnh nhân không tồn tại");
			return result;
		}
		call.setPatient(patient);

		result.setData(callRepo.save(call));

		return result;
	}

	public Result delete(int id) {
		Result result = new Result();
		Call call = callRepo.findById(id).orElse(null);
		if (call == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("Cuộc gọi không tồn tại");
		} else {
			callRepo.delete(call);
			result.setMessage("success");
		}
		return result;
	}
}
