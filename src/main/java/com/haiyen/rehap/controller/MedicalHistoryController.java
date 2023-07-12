package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.MedicalHistoryService;

@RestController
@RequestMapping("/api/v1")
public class MedicalHistoryController {
	@Autowired
	private MedicalHistoryService medicalHistoryService;

	@GetMapping("/medicalHistory")
	public ResponseEntity<Result> findByPatientId(@RequestParam("patientId") int patientId) {
		return new ResponseEntity<Result>(medicalHistoryService.findByPatientId(patientId), HttpStatus.OK);
	}
}
