package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.InitiateStkPush;
import com.theophiluskibet.service.PaymentService;
import com.theophiluskibet.utils.ResponseHandler;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/")
public class PaymentsController {

    String password = new Base64().decode("").toString();
    @Autowired
    private PaymentService paymentService;

    @PostMapping("stkPush")
    public void initiateStkPush(InitiateStkPush initiateStkPush) {
        paymentService.initiateStkPush(initiateStkPush);
    }

    @PostMapping("callback")
    public void stkCallBack() {

    }

}
