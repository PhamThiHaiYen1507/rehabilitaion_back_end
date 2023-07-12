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

import com.haiyen.rehap.entities.UserInfo;
import com.haiyen.rehap.exception.ExceptionResult;
import com.haiyen.rehap.request.DeleteRequestID;
import com.haiyen.rehap.result.UsersResult;
import com.haiyen.rehap.service.UsersService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	private UsersService usersService;

	@GetMapping("/users/all")
	public ResponseEntity<UsersResult> findAllUserInfo() {
		return new ResponseEntity<UsersResult>(usersService.findAll(), HttpStatus.OK);
	}

	@DeleteMapping("/users")
	public ResponseEntity<UsersResult> delete(@RequestBody DeleteRequestID request) {
		return new ResponseEntity<UsersResult>(usersService.delete(request.getId()), HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<UsersResult> findById(@RequestParam("id") int id) {
		return new ResponseEntity<UsersResult>(usersService.findById(id), HttpStatus.OK);
	}

	/* ---------------- CREATE NEW UserInfo ------------------------ */
	@PostMapping("/users")
	public ResponseEntity<UsersResult> create(@RequestBody UserInfo userInfo) {
		return new ResponseEntity<UsersResult>(usersService.create(userInfo), HttpStatus.OK);
	}

	/* ---------------- UPDATE UserInfo ------------------------ */
	@PutMapping("/users")
	public ResponseEntity<UsersResult> update(@RequestBody UserInfo userInfo) {
		return new ResponseEntity<UsersResult>(usersService.update(userInfo), HttpStatus.OK);
	}

	/* ---------------- check phone number ------------------------ */
	@PostMapping("/users/checkPhoneNumber")
	public ResponseEntity<Boolean> findPhoneNumber(@RequestBody UserInfo userInfo) {
		return new ResponseEntity<Boolean>(usersService.checkPhoneNumber(userInfo.getPhoneNumber()), HttpStatus.OK);
	}

	/* ---------------- login ------------------------ */
	@PostMapping("/login")
	public ResponseEntity<UsersResult> login(@RequestBody UserInfo userInfo) throws ExceptionResult {
		return new ResponseEntity<UsersResult>(usersService.login(userInfo), HttpStatus.OK);
	}
}