package com.theophiluskibet.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("event")
public class EventDto {
    @Id
    public String id;
    public String title;

    public Date date;
    public String location;
    public int capacity;

    public RegistrationDto[] registrations;
    public String eventType;

}


