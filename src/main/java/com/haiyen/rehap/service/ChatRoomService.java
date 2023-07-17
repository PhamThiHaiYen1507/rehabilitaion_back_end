package com.haiyen.rehap.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.ChatRoom;
import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.repository.ChatRoomRepository;
import com.haiyen.rehap.repository.DoctorsRepository;
import com.haiyen.rehap.repository.PatientsRepository;
import com.haiyen.rehap.result.Result;

@Service
public class ChatRoomService {
	@Autowired
	ChatRoomRepository chatRoomRepo;

	@Autowired
	DoctorsRepository doctorsRepository;

	@Autowired
	PatientsRepository patientsRepository;

	public Result<List<ChatRoom>> findByPatientId(int patientId) {
		Result<List<ChatRoom>> result = new Result<List<ChatRoom>>();
		List<ChatRoom> chatList = chatRoomRepo.findByPatientId(patientId);
		if (chatList.isEmpty()) {
			result.setMessage("Không có hội thoại");
		}
		result.setData(chatList);
		return result;
	}

	public Result<List<ChatRoom>> findByDoctorId(int doctorId) {
		Result<List<ChatRoom>> result = new Result<List<ChatRoom>>();
		List<ChatRoom> chatList = chatRoomRepo.findByDoctorId(doctorId);
		if (chatList.isEmpty()) {
			result.setMessage("Không có hội thoại");
		}
		result.setData(chatList);
		return result;
	}

	public Result<ChatRoom> create(ChatRoom chatRoom) {
		Result<ChatRoom> result = new Result<ChatRoom>();
		// Lấy doctorId từ body request
		int doctorId = chatRoom.getDoctor().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		DoctorInfo doctor = doctorsRepository.findById(doctorId).orElse(null);
		if (doctor == null) {
			result.setMessage("Bác sĩ không tồn tại");
			return result;
		}
		chatRoom.setDoctor(doctor);// Lấy patientId từ body request
		int patientId = chatRoom.getPatient().getId();

		// Kiểm tra bác sĩ có tồn tại trong cơ sở dữ liệu hay không
		PatientsInfo patient = patientsRepository.findById(patientId).orElse(null);
		if (patient == null) {
			result.setMessage("Bệnh nhân không tồn tại");
			return result;
		}
		chatRoom.setPatient(patient);

		result.setData(chatRoomRepo.save(chatRoom));

		return result;
	}

	public Result<ChatRoom> delete(int id) {
		Result<ChatRoom> result = new Result<ChatRoom>();
		ChatRoom chatRoom = chatRoomRepo.findById(id).orElse(null);
		if (chatRoom == null) {

			result.setMessage("Hội thoại không tồn tại");
		} else {
			chatRoomRepo.delete(chatRoom);
			result.setMessage("success");
		}
		return result;
	}
}
