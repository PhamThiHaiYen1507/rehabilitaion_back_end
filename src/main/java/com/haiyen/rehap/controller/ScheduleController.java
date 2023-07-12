package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.entities.Schedule;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.ScheduleService;

@RestController
@RequestMapping("/api/v1")
public class ScheduleController {
	@Autowired
	private ScheduleService scheduleService;

	@GetMapping("/schedule")
	public ResponseEntity<Result> findByPatientId(@RequestParam("patientId") int patientId) {
		return new ResponseEntity<Result>(scheduleService.findByPatientId(patientId), HttpStatus.OK);
	}

	@GetMapping("/scheduleDoctor")
	public ResponseEntity<Result> findByDoctorId(@RequestParam("doctorId") int doctorId) {
		return new ResponseEntity<Result>(scheduleService.findByDoctorId(doctorId), HttpStatus.OK);
	}

	@DeleteMapping("/schedule")
	public ResponseEntity<Result> delete(@RequestBody DeleteRequestID request) {
		return new ResponseEntity<Result>(scheduleService.delete(request.getId()), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW Schedule ------------------------ */
	@PostMapping("/schedule")
	public ResponseEntity<Result> create(@RequestBody Schedule schedule) {
		return new ResponseEntity<Result>(scheduleService.create(schedule), HttpStatus.OK);
	}

	/* ---------------- UPDATE Schedule ------------------------ */
	@PutMapping("/schedule")
	public ResponseEntity<Result> update(@RequestBody Schedule schedule) {
		return new ResponseEntity<Result>(scheduleService.update(schedule), HttpStatus.OK);
	}
}
