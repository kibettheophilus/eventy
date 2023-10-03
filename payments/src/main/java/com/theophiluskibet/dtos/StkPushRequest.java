package com.theophiluskibet.dtos;

import lombok.Data;

@Data
public class StkPushRequest {
    private String businessShortCode;
    public String password;
    private String timeStamp;
    private String transactionType;
    private String amount;
    private String partyA;
    private String partyB;
    private String phoneNumber;
    private String callBackUrl;
    private String accountReference;
    private String transactionDesc;
}
