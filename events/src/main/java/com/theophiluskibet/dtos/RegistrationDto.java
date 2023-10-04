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

    public String eventId;

    public RegistrationDto(String username, String createdAt, String eventId) {
        super();
        this.username = username;
        this.createdAt = createdAt;
        this.eventId = eventId;
    }

}
