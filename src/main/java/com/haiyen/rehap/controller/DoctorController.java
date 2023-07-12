package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.result.DoctorsResult;

import com.haiyen.rehap.service.DoctorsService;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	@Autowired
	private DoctorsService doctorsService;

	@GetMapping("/doctors/all")
	public ResponseEntity<DoctorsResult> findAllDoctorsInfo() {
		return new ResponseEntity<DoctorsResult>(doctorsService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/doctors")
	public ResponseEntity<DoctorsResult> findById(@RequestParam("id") int id) {
		return new ResponseEntity<DoctorsResult>(doctorsService.findById(id), HttpStatus.OK);
	}
}
