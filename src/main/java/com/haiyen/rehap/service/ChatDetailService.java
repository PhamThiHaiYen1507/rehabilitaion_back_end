package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.repository.ChatDetailRepository;
import com.haiyen.rehap.result.Result;

@Service
public class ChatDetailService {
    @Autowired
    ChatDetailRepository chetDetailRepo;

    public Result findAll() {
        Result result = new Result();
        result.setData(chetDetailRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

}
