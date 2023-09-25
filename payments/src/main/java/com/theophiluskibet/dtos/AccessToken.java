package com.theophiluskibet.dtos;

import lombok.Data;

/**
 * Add @Data annotation generates getters and setters
 */
@Data
public class AccessToken {
    private String accessToken;
    private String expiresIn;
}
