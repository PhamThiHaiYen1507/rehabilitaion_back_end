package com.haiyen.rehap.controller;

import java.util.List;

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

import com.haiyen.rehap.entities.UserInfo;
import com.haiyen.rehap.exception.ExceptionResult;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.UsersService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/users/all")
	public ResponseEntity<Result<List<UserInfo>>> findAllUserInfo() {
		return new ResponseEntity<Result<List<UserInfo>>>(usersService.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/users")
	public ResponseEntity<Result<UserInfo>> delete(@RequestBody DeleteRequestID request) {
		return new ResponseEntity<Result<UserInfo>>(usersService.delete(request.getId()), HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<Result<UserInfo>> findById(@RequestParam("id") int id) {
		return new ResponseEntity<Result<UserInfo>>(usersService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW UserInfo ------------------------ */
	@PostMapping("/users")
	public ResponseEntity<Result<UserInfo>> create(@RequestBody UserInfo userInfo) throws ExceptionResult {
		return new ResponseEntity<Result<UserInfo>>(usersService.create(userInfo), HttpStatus.OK);
	}

	/* ---------------- UPDATE UserInfo ------------------------ */
	@PutMapping("/users")
	public ResponseEntity<Result<UserInfo>> update(@RequestBody UserInfo userInfo) throws ExceptionResult {
		return new ResponseEntity<Result<UserInfo>>(usersService.update(userInfo), HttpStatus.OK);
	}

	/* ---------------- check phone number ------------------------ */
	@PostMapping("/users/checkPhoneNumber")
	public ResponseEntity<Result<Boolean>> findPhoneNumber(@RequestBody UserInfo userInfo) throws ExceptionResult {
		return new ResponseEntity<Result<Boolean>>(usersService.checkPhoneNumber(userInfo.getPhoneNumber()),
				HttpStatus.OK);
	}

	/* ---------------- login ------------------------ */
	@PostMapping("/login")
	public ResponseEntity<Result<UserInfo>> login(@RequestBody UserInfo userInfo) throws ExceptionResult {
		return new ResponseEntity<Result<UserInfo>>(usersService.login(userInfo), HttpStatus.OK);
	}
}