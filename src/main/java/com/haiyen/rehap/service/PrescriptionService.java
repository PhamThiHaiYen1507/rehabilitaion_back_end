package com.haiyen.rehap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haiyen.rehap.entities.Prescription;
import com.haiyen.rehap.repository.PrescriptionRepository;
import com.haiyen.rehap.result.Result;

@Service
public class PrescriptionService {
    @Autowired
    PrescriptionRepository prescriptionRepo;

    public Result<List<Prescription>> findAll() {
        Result<List<Prescription>> result = new Result<List<Prescription>>();
        result.setData(prescriptionRepo.findAll());
        result.setMessage("Thành công");
        return result;
    }

    public Result<Prescription> findByPatientId(int patientId) {
        Result<Prescription> result = new Result<Prescription>();
        Prescription prescription = prescriptionRepo.findByPatientId(patientId);
        if (prescription == null) {
            result.setMessage("Không có đơn thuốc");
        }
        result.setData(prescription);
        return result;
    }

}
