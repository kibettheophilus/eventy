package com.theophiluskibet.service;

import com.theophiluskibet.dtos.AccessToken;
import com.theophiluskibet.dtos.InitiateStkPush;
import com.theophiluskibet.dtos.StkPushRequest;
import com.theophiluskibet.repositories.PaymentRepository;
import com.theophiluskibet.utils.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: 25/09/2023 Add functionalities 
@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public void saveAccessToken(AccessToken accessToken) {
        paymentRepository.save(accessToken);
    }

    public void initiateStkPush() {
       // if (initiateStkPush.getPhoneNumber().isEmpty() || initiateStkPush.getAmount().isEmpty()) {
            //
    //    } else {
            StkPushRequest stkPushRequest = new StkPushRequest();
            ResponseHandler responseHandler = new ResponseHandler();
            stkPushRequest.setAmount("1");
            stkPushRequest.setPhoneNumber("+254700618336");
            stkPushRequest.setPartyA("+254700618336");
            stkPushRequest.setPartyB("174379");
            stkPushRequest.setBusinessShortCode("174379");
            stkPushRequest.setCallBackUrl("");
            stkPushRequest.setTransactionType("CustomerBuyGoodsOnline");
            stkPushRequest.setAccountReference("Test");
            stkPushRequest.setTransactionDesc("Test");
            stkPushRequest.setTimeStamp("");
            responseHandler.setData(stkPushRequest);
     //   }


    }

}
