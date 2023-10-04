package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.InitiateStkPush;
import com.theophiluskibet.service.PaymentService;
import com.theophiluskibet.utils.ResponseHandler;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/")
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<String> test() {
        return ResponseEntity.ok(paymentService.home());
    }

    @PostMapping("stkPush")
    public void initiateStkPush(@RequestBody InitiateStkPush initiateStkPush) {
        paymentService.initiateStkPush(initiateStkPush);
    }

    @PostMapping("callback")
    public void stkCallBack() {

    }

}
