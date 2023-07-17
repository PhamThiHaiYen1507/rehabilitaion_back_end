package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.ChatDetail;
import com.haiyen.rehap.repository.ChatDetailRepository;
import com.haiyen.rehap.result.Result;

@Service
public class ChatDetailService {
    @Autowired
    ChatDetailRepository chetDetailRepo;

    public Result<List<ChatDetail>> findAll() {
        Result<List<ChatDetail>> result = new Result<List<ChatDetail>>();
        result.setData(chetDetailRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

}
