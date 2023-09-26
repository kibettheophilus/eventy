package com.theophiluskibet.dtos;

import lombok.Data;

/**
 * Adding @Data annotation generates getters and setters
 */
@Data
public class AccessToken {
    private String accessToken;
    private String expiresIn;
}
