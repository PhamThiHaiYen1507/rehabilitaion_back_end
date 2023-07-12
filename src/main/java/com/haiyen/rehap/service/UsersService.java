package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.UserInfo;
import com.haiyen.rehap.exception.ExceptionResult;
import com.haiyen.rehap.repository.UsersRepository;
import com.haiyen.rehap.result.UsersResult;
import com.haiyen.rehap.result.UsersResult.Status;

@Service
public class UsersService {

	@Autowired
	UsersRepository userRepo;

	public UsersResult findAll() {
		UsersResult result = new UsersResult();
		result.setData(userRepo.findAll());
		return result;
	}

	public UsersResult findById(int id) {
		UsersResult result = new UsersResult();
		UserInfo user = userRepo.findById(id).orElse(null);
		if (user == null) {
			result.setMessage("Không tìm thấy người dùng");
		}
		result.setData(user);
		return result;
	}

	public UsersResult create(UserInfo user) {
		UsersResult result = new UsersResult();
		if (userRepo.findUsersByPhoneNumber(user.getPhoneNumber()).isEmpty() == true) {
			result.setData(userRepo.save(user));
		} else {
			result.setStatus(Status.FAILED);
			result.setMessage("Số điện thoại đã tồn tại");
		}
		return result;
	}

	public Boolean checkPhoneNumber(String phoneNumber) {
		if (userRepo.findUsersByPhoneNumber(phoneNumber).isEmpty() == true) {
			return false;
		} else {
			return true;
		}
	}

	public UsersResult update(UserInfo user) {
		UsersResult result = new UsersResult();
		if (!userRepo.findById(user.getId()).isPresent()) {
			result.setStatus(Status.FAILED);
			result.setMessage("user Not Found");
		} else {
			result.setData(userRepo.save(user));
		}
		return result;
	}

	public UsersResult delete(int id) {
		UsersResult result = new UsersResult();
		UserInfo user = userRepo.findById(id).orElse(null);
		if (user == null) {
			result.setStatus(Status.FAILED);
			result.setMessage("user Not Found");
		} else {
			userRepo.delete(user);
			result.setMessage("success");
		}
		return result;
	}

	public UsersResult login(UserInfo userInfo) throws ExceptionResult {
		System.out.println(userInfo.getPhoneNumber() + userInfo.getPassword());
		UsersResult result = new UsersResult();
		UserInfo user = userRepo.login(userInfo.getPhoneNumber(), userInfo.getPassword());
		if (user == null) {
			result.setMessage("Số điện thoại hoặc mật khẩu không chính xác");
			result.setStatus(Status.FAILED);
			throw new ExceptionResult("NOT_FOUNT");

		} else {
			result.setData(user);
			result.setMessage("Đăng nhập thành công");
		}
		return result;
	}

}
