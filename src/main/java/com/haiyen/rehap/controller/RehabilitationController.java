package com.haiyen.rehap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.haiyen.rehap.result.Result;
import com.haiyen.rehap.service.RehabilitationService;

@RestController
@RequestMapping("/api/v1")
public class RehabilitationController {
    @Autowired
    private RehabilitationService rehabilitationService;

    @GetMapping("/rehabilitation")
    public ResponseEntity<Result> findAll() {
        return new ResponseEntity<Result>(rehabilitationService.findAll(), HttpStatus.OK);
    }
}
