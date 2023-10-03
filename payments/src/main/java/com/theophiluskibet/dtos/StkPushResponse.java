package com.theophiluskibet.dtos;

import lombok.Data;

@Data
public class StkPushResponse {
    private String merchantRequestID;
    private String checkoutRequestID;
    private String responseCode;
    private String responseDescription;
    private String customerMessage;
}
