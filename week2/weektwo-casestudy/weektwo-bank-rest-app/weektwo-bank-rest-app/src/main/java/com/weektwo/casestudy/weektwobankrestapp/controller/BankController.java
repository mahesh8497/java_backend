package com.weektwo.casestudy.weektwobankrestapp.controller;


import com.weektwo.casestudy.weektwobankrestapp.domain.BankAccount;
import com.weektwo.casestudy.weektwobankrestapp.dto.AppResponse;
import com.weektwo.casestudy.weektwobankrestapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bank")
@RestController
public class BankController {
    @Autowired
    private BankService service;

    @PostMapping // POST -> http://localhost:8080/bank/
    public ResponseEntity<AppResponse<Integer>> createBankAccount(@RequestBody BankAccount ba) {

        service.createNewAccount(ba);

        var response = new AppResponse<Integer>();
        response.setMsg("account created successfully");
        response.setSts("success");
        response.setBody(0);
        return ResponseEntity.ok(response);
    }

    @PutMapping // PUT -> http://localhost:8080/123456
    public ResponseEntity<AppResponse<Double>> withdrawMoney(@RequestBody BankAccount ba) {
        double amt = service.withdraw(ba.getAcNum(), ba.getBalance());
        var response = new AppResponse<Double>();
        response.setMsg("account created successfully");
        response.setSts("success");
        response.setBody(amt);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{prefix}")
    public ResponseEntity<AppResponse<List<BankAccount>>> accountsStartWith(@PathVariable String prefix) {
        var response = new AppResponse<List<BankAccount>>();
        response.setMsg("account list");
        response.setSts("success");
        response.setBody(service.namesStartsWith(prefix));

        return ResponseEntity.ok(response);
    }
}