package com.theophiluskibet.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StkPushRequest {
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;
    @JsonProperty("Password")
    public String password;
    @JsonProperty("Timestamp")
    private String timeStamp;
    @JsonProperty("TransactionType")
    private String transactionType;
    @JsonProperty("Amount")
    private String amount;
    @JsonProperty("PartyA")
    private String partyA;
    @JsonProperty("PartyB")
    private String partyB;
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
    @JsonProperty("CallBackURL")
    private String callBackUrl;
    @JsonProperty("AccountReference")
    private String accountReference;
    @JsonProperty("TransactionDesc")
    private String transactionDesc;
}
