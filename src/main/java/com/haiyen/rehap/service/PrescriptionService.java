package com.haiyen.rehap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.Prescription;
import com.haiyen.rehap.repository.PrescriptionRepository;
import com.haiyen.rehap.result.Result;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepo;

    public Result findAll() {
        Result result = new Result();
        result.setData(prescriptionRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

    public Result findByPatientId(int patientId) {
        Result result = new Result();
        Prescription prescription = prescriptionRepo.findByPatientId(patientId);
        if (prescription == null) {
            result.setMessage("Không có đơn thuốc");
        }
        result.setData(prescription);
        return result;
    }

}
