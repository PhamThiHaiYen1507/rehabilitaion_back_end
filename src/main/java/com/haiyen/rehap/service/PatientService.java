package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.PatientsInfo;
import com.haiyen.rehap.repository.PatientsRepository;
import com.haiyen.rehap.result.Result;

@Service
public class PatientService {
    @Autowired
    PatientsRepository patientsRepo;

    public Result<List<PatientsInfo>> findAll() {
        Result<List<PatientsInfo>> result = new Result<List<PatientsInfo>>();
        result.setData(patientsRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

    public Result<PatientsInfo> findById(int id) {
        Result<PatientsInfo> result = new Result<PatientsInfo>();
        PatientsInfo patientInfo = patientsRepo.findById(id).orElse(null);
        if (patientInfo == null) {
            result.setMessage("Không tìm thấy bệnh nhân");
        }
        result.setData(patientInfo);
        return result;
    }

}
