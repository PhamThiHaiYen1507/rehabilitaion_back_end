package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.entities.ChatRoom;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.ChatRoomService;

@RestController
@RequestMapping("/api/v1")
public class ChatRoomController {
	@Autowired
	private ChatRoomService chatRoomService;

	@GetMapping("/chatRoom")
	public ResponseEntity<Result> findByPatientId(@RequestParam("patientId") int patientId) {
		return new ResponseEntity<Result>(chatRoomService.findByPatientId(patientId), HttpStatus.OK);
	}

	@GetMapping("/chatRoomDoctor")
	public ResponseEntity<Result> findByDoctorId(@RequestParam("doctorId") int doctorId) {
		return new ResponseEntity<Result>(chatRoomService.findByDoctorId(doctorId), HttpStatus.OK);
	}

	@DeleteMapping("/chatRoom")
	public ResponseEntity<Result> delete(@RequestBody DeleteRequestID request) {
		return new ResponseEntity<Result>(chatRoomService.delete(request.getId()), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW Call ------------------------ */
	@PostMapping("/chatRoom")
	public ResponseEntity<Result> create(@RequestBody ChatRoom chatRoom) {
		return new ResponseEntity<Result>(chatRoomService.create(chatRoom), HttpStatus.OK);
	}

}
