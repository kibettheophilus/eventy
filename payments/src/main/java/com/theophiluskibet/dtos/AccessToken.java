package com.theophiluskibet.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Adding @Data annotation generates getters and setters
 */
@Data
@Document("mpesaAccessToken")
public class AccessToken {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private String expiresIn;
}
