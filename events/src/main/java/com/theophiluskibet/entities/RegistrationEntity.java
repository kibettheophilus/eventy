package com.theophiluskibet.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class RegistrationEntity {

    @Id
    public String id;

    public String username;

    public String createdAt;

    public String eventId;

    public RegistrationEntity(String username, String createdAt, String eventId) {
        super();
        this.username = username;
        this.createdAt = createdAt;
        this.eventId = eventId;
    }

}