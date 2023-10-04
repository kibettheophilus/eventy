package com.theophiluskibet.service;

import com.theophiluskibet.dtos.AccessToken;
import com.theophiluskibet.dtos.InitiateStkPush;
import com.theophiluskibet.dtos.InitiateStkPushRes;
import com.theophiluskibet.dtos.StkPushRequest;
import com.theophiluskibet.repositories.PaymentRepository;
import com.theophiluskibet.utils.ExternalApiCalls;
import com.theophiluskibet.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

// TODO: 25/09/2023 Add functionalities 
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    ExternalApiCalls externalApiCalls;

    public String home() {
        return "Home";
    }

    public void saveAccessToken(AccessToken accessToken) {
        paymentRepository.save(accessToken);
    }

    public void initiateStkPush(InitiateStkPush initiateStkPush) {
        // TimeStamp
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedTimeStamp = timeStamp.format(customFormat);

        byte[] encodedBytes = Base64.getEncoder().encode(("174379" + "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919" + formattedTimeStamp).getBytes());
        String password = new String(encodedBytes);

        if (initiateStkPush.getPhoneNumber().isEmpty() || initiateStkPush.getAmount().isEmpty()) {

        } else {
            StkPushRequest stkPushRequest = new StkPushRequest();
            stkPushRequest.setAmount(initiateStkPush.getAmount());
            stkPushRequest.setPhoneNumber(initiateStkPush.getPhoneNumber());
            stkPushRequest.setPartyA(initiateStkPush.getPhoneNumber());
            stkPushRequest.setPartyB("174379");
            stkPushRequest.setBusinessShortCode("174379");
            stkPushRequest.setCallBackUrl("https://mydomain.com/path");
            stkPushRequest.setTransactionType("CustomerBuyGoodsOnline");
            stkPushRequest.setAccountReference("Test");
            stkPushRequest.setTransactionDesc("Test");
            stkPushRequest.setTimeStamp(formattedTimeStamp);
            stkPushRequest.setPassword(password);

            externalApiCalls.initiateStkPush(stkPushRequest);
        }


    }

}
