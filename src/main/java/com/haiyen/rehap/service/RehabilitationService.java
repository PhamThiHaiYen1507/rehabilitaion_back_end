package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.Rehabilitation;
import com.haiyen.rehap.repository.RehabilitationRepository;
import com.haiyen.rehap.result.Result;

@Service
public class RehabilitationService {
    @Autowired
    RehabilitationRepository rehabilitationRepo;

    public Result<List<Rehabilitation>> findAll() {
        Result<List<Rehabilitation>> result = new Result<List<Rehabilitation>>();
        result.setData(rehabilitationRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

}
