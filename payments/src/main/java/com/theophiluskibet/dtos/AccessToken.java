package com.theophiluskibet.dtos;

import lombok.Data;

@Data
public class AccessToken {
    private String accessToken;
    private String expiresIn;
}
