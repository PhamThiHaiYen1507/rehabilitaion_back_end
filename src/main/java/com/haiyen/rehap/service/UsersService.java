package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	public Result<Boolean> checkPhoneNumber(String phoneNumber) throws ExceptionResult {
		Result<Boolean> result = new Result<Boolean>();
		try {
			UserInfo userPhoneNumber = userRepo.findUsersByPhoneNumber(phoneNumber);
			if (userPhoneNumber == null) {
				throw new ExceptionResult("Số điện thoại chưa được đăng ký với nhân viên bệnh viện",
						HttpStatus.BAD_REQUEST);
			} else {
				if (userPhoneNumber.getPassword() == null) {
					result.setData(false);
				} else {
					result.setData(true);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public Result<UserInfo> update(UserInfo user) throws ExceptionResult {
		Result<UserInfo> result = new Result<UserInfo>();
		UserInfo userPhoneNumber = userRepo.findUsersByPhoneNumber(user.getPhoneNumber());
		if (userPhoneNumber == null) {
			throw new ExceptionResult("Không tìm thấy người dùng", HttpStatus.BAD_REQUEST);
		} else {
			if (user.getPassword().equals(userPhoneNumber.getPassword())) {
				throw new ExceptionResult("Mật khẩu mới không được trùng với mật khẩu hiện tại",
						HttpStatus.BAD_REQUEST);
			} else {
				userPhoneNumber.setPassword(user.getPassword());
				result.setData(userRepo.save(userPhoneNumber));
			}
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
		Result<UserInfo> result = new Result<UserInfo>();
		UserInfo user = userRepo.login(userInfo.getPhoneNumber(), userInfo.getPassword());
		UserInfo userPhoneNumber = userRepo.findUsersByPhoneNumber(userInfo.getPhoneNumber());

		try {
			if (userPhoneNumber == null) {
				throw new ExceptionResult("Số điện thoại chưa được kích hoạt, vui lòng Đăng ký",
						HttpStatus.BAD_REQUEST);
			} else {
				if (user == null) {
					throw new ExceptionResult("Mật khẩu không chính xác", HttpStatus.BAD_REQUEST);
				} else {
					result.setData(user);
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return result;
	}

}
