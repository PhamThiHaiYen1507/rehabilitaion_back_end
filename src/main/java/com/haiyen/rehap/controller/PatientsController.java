package com.haiyen.rehap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.PatientService;

@RestController
@RequestMapping("/api/v1")
public class PatientsController {
    @Autowired
    private PatientService patientsService;

    @GetMapping("/patients/all")
    public ResponseEntity<Result<List<PatientsInfo>>> findAllDoctorsInfo() {
        return new ResponseEntity<Result<List<PatientsInfo>>>(patientsService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<Result<PatientsInfo>> findById(@RequestParam("userId") int userId) {
        return new ResponseEntity<Result<PatientsInfo>>(patientsService.findByUserId(userId), HttpStatus.OK);
    }
}
