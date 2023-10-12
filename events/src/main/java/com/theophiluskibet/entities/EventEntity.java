package com.theophiluskibet.entities;

import com.theophiluskibet.dtos.RegistrationDto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("event")
public class EventEntity {
    @Id
    public String id;
    public String title;

    public Date date;
    public String location;
    public int capacity;

    public RegistrationEntity[] registrations;
    public String eventType;
}