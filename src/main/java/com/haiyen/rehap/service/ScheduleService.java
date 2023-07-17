package com.haiyen.rehap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.entities.Schedule;
import com.haiyen.rehap.repository.DoctorsRepository;
import com.haiyen.rehap.repository.PatientsRepository;
import com.haiyen.rehap.repository.ScheduleRepository;
import com.haiyen.rehap.result.Result;

@Service
public class ScheduleService {
	@Autowired
	ScheduleRepository scheduleRepo;

	@Autowired
	DoctorsRepository doctorsRepository;

	@Autowired
	PatientsRepository patientsRepository;

	public Result<List<Schedule>> findByPatientId(int patientId) {
		Result<List<Schedule>> result = new Result<List<Schedule>>();
		List<Schedule> scheduleList = scheduleRepo.findByPatientId(patientId);
		if (scheduleList.isEmpty()) {
			result.setMessage("Không có lịch hẹn khám bệnh");
		}
		result.setData(scheduleList);
		return result;
	}

	public Result<List<Schedule>> findByDoctorId(int doctorId) {
		Result<List<Schedule>> result = new Result<List<Schedule>>();
		List<Schedule> scheduleList = scheduleRepo.findByDoctorId(doctorId);
		if (scheduleList.isEmpty()) {
			result.setMessage("Không có lịch hẹn khám bệnh");
		}
		result.setData(scheduleList);
		return result;
	}

	public Result<Schedule> create(Schedule schedule) {
		Result<Schedule> result = new Result<Schedule>();
		int doctorId = schedule.getDoctor().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		DoctorInfo doctor = doctorsRepository.findById(doctorId).orElse(null);
		if (doctor == null) {
			result.setMessage("Bác sĩ không tồn tại");
			return result;
		}

		// Lấy patientId từ body request
		int patientId = schedule.getPatient().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		PatientsInfo patient = patientsRepository.findById(patientId).orElse(null);
		if (patient == null) {
			result.setMessage("Bệnh nhân không tồn tại");
			return result;
		}
		schedule.setPatient(patient);
		result.setData(scheduleRepo.save(schedule));

		return result;
	}

	public Result<Schedule> update(Schedule schedule) {
		Result<Schedule> result = new Result<Schedule>();
		if (!scheduleRepo.findById(schedule.getId()).isPresent()) {
			result.setMessage("Lịch hẹn không tồn tại");
		} else {
			result.setData(scheduleRepo.save(schedule));
		}
		return result;
	}

	public Result<Schedule> delete(int id) {
		Result<Schedule> result = new Result<Schedule>();
		Schedule schedule = scheduleRepo.findById(id).orElse(null);
		if (schedule == null) {
			result.setMessage("Lịch hẹn không tồn tại");
		} else {
			scheduleRepo.delete(schedule);
			result.setMessage("success");
		}
		return result;
	}
}
