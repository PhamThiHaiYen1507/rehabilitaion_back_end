package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.repository.RehabilitationRepository;
import com.haiyen.rehap.result.Result;

@Service
public class RehabilitationService {
    @Autowired
    RehabilitationRepository rehabilitationRepo;

    public Result findAll() {
        Result result = new Result();
        result.setData(rehabilitationRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

}
