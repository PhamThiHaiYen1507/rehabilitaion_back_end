package com.haiyen.rehap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.entities.DoctorInfo;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.DoctorsService;

@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	@Autowired
	private DoctorsService doctorsService;

	@GetMapping("/doctors/all")
	public ResponseEntity<Result<List<DoctorInfo>>> findAllDoctorsInfo() {
		return new ResponseEntity<Result<List<DoctorInfo>>>(doctorsService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/doctors")
	public ResponseEntity<Result<DoctorInfo>> findById(@RequestParam("userId") int userId) {
		return new ResponseEntity<Result<DoctorInfo>>(doctorsService.findByUserId(userId), HttpStatus.OK);
	}
}
