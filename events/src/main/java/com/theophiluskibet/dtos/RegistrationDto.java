package com.theophiluskibet.dtos;

import com.google.type.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("registration")
public class RegistrationDto {

    @Id
    public String id;

    public String username;

    public String createdAt;

    public RegistrationDto(String id, String username, String createdAt) {
        super();
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
    }

}
