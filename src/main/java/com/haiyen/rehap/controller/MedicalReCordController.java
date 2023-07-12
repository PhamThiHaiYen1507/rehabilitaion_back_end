package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.MedicalReCordService;

@RestController
@RequestMapping("/api/v1")
public class MedicalReCordController {
	@Autowired
	private MedicalReCordService medicalReCordService;

	@GetMapping("/medicalRecord/all")
	public ResponseEntity<Result> findAllDoctorsInfo() {
		return new ResponseEntity<Result>(medicalReCordService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/medicalRecord")
	public ResponseEntity<Result> findByPatientId(@RequestParam("patientId") int patientId) {
		return new ResponseEntity<Result>(medicalReCordService.findByPatientId(patientId), HttpStatus.OK);
	}
}
