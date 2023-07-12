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

import com.haiyen.rehap.entities.Call;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.CallService;

@RestController
@RequestMapping("/api/v1")
public class CallController {
	@Autowired
	private CallService callService;

	@GetMapping("/call")
	public ResponseEntity<Result> findByPatientId(@RequestParam("patientId") int patientId) {
		return new ResponseEntity<Result>(callService.findByPatientId(patientId), HttpStatus.OK);
	}

	@GetMapping("/callDoctor ")
	public ResponseEntity<Result> findByDoctorId(@RequestParam("doctorId") int doctorId) {
		return new ResponseEntity<Result>(callService.findByDoctorId(doctorId), HttpStatus.OK);
	}

	@DeleteMapping("/call")
	public ResponseEntity<Result> delete(@RequestBody DeleteRequestID request) {
		return new ResponseEntity<Result>(callService.delete(request.getId()), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW Call ------------------------ */
	@PostMapping("/call")
	public ResponseEntity<Result> create(@RequestBody Call schedule) {
		return new ResponseEntity<Result>(callService.create(schedule), HttpStatus.OK);
	}

}
