package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.UserInfo;
import com.haiyen.rehap.exception.ExceptionResult;
import com.haiyen.rehap.repository.UsersRepository;
import com.haiyen.rehap.result.Result;

@Service
public class UsersService {

	@Autowired
	UsersRepository userRepo;

	public Result<List<UserInfo>> findAll() {
		Result<List<UserInfo>> result = new Result<List<UserInfo>>();
		result.setData(userRepo.findAll());
		return result;
	}

	public Result<UserInfo> findById(int id) {
		Result<UserInfo> result = new Result<UserInfo>();
		UserInfo user = userRepo.findById(id).orElse(null);
		if (user == null) {
			result.setMessage("Không tìm thấy người dùng");
		}
		result.setData(user);
		return result;
	}

	public Result<UserInfo> create(UserInfo user) {
		Result<UserInfo> result = new Result<UserInfo>();
		if (userRepo.findUsersByPhoneNumber(user.getPhoneNumber()).isEmpty() == true) {
			result.setData(userRepo.save(user));
		} else {

			result.setMessage("Số điện thoại đã tồn tại");
		}
		return result;
	}

	public Result<Boolean> checkPhoneNumber(String phoneNumber) throws ExceptionResult {
		Result<Boolean> result = new Result<Boolean>();
		try {
			if (userRepo.findUsersByPhoneNumber(phoneNumber).isEmpty() == true) {
				result.setData(userRepo.findUsersByPhoneNumber(phoneNumber).isEmpty());
				;
			} else {
				throw new ExceptionResult("Số điện thoại đã được đăng ký", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public Result<UserInfo> update(UserInfo user) {
		Result<UserInfo> result = new Result<UserInfo>();
		if (!userRepo.findById(user.getId()).isPresent()) {
			// result.setStatus(HttpStatus.OK);
			result.setMessage("user Not Found");
		} else {
			result.setData(userRepo.save(user));
		}
		return result;
	}

	public Result<UserInfo> delete(int id) {
		Result<UserInfo> result = new Result<UserInfo>();
		UserInfo user = userRepo.findById(id).orElse(null);
		if (user == null) {
			result.setMessage("user Not Found");
		} else {
			userRepo.delete(user);
			result.setMessage("success");
		}
		return result;
	}

	public Result<UserInfo> login(UserInfo userInfo) throws ExceptionResult {
		System.out.println(userInfo.getPhoneNumber() + userInfo.getPassword());
		Result<UserInfo> result = new Result<UserInfo>();
		UserInfo user = userRepo.login(userInfo.getPhoneNumber(), userInfo.getPassword());
		try {
			if (user == null) {
				throw new ExceptionResult("Số điện thoại hoặc mật khẩu không chính xác", HttpStatus.BAD_REQUEST);
			} else {
				result.setData(user);
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

}
