package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.repository.PatientsRepository;
import com.haiyen.rehap.result.Result;

@Service
public class PatientService {
    @Autowired
    PatientsRepository patientsRepo;

    public Result findAll() {
        Result result = new Result();
        result.setData(patientsRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

    public Result findById(int id) {
        Result result = new Result();
        PatientsInfo patientInfo = patientsRepo.findById(id).orElse(null);
        if (patientInfo == null) {
            result.setMessage("Không tìm thấy bệnh nhân");
        }
        result.setData(patientInfo);
        return result;
    }

}
