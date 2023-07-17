package com.haiyen.rehap.controller;

import java.util.List;

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
import com.haiyen.rehap.exception.ExceptionResult;
import com.haiyen.rehap.exception.GlobalExceptionHandler;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.CallService;

@RestController
@RequestMapping("/api/v1")
public class CallController extends GlobalExceptionHandler {
	@Autowired
	private CallService callService;

	@GetMapping("/call")
	public ResponseEntity<Result<List<Call>>> findByPatientId(@RequestParam("patientId") int patientId)
			throws Exception {
		try {
			return new ResponseEntity<Result<List<Call>>>(callService.findByPatientId(patientId), HttpStatus.OK);
		} catch (Exception e) {
			throw e;
		}

	}

	@GetMapping("/callDoctor")
	public ResponseEntity<Result<List<Call>>> findByDoctorId(@RequestParam("doctorId") int doctorId) throws Exception {
		Result<List<Call>> res = callService.findByDoctorId(doctorId);
		if (res.getData().size() == 0) {
			throw new ExceptionResult(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Result<List<Call>>>(res, HttpStatus.OK);

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
