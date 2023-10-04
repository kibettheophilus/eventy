package com.theophiluskibet.dtos;

import lombok.Data;

@Data
public class InitiateStkPush {
    private String amount;
    private String phoneNumber;
    private String eventId;
}
