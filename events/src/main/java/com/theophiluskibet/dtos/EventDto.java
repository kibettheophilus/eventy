package com.theophiluskibet.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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

    public EventDto(String id,String title,Date date, String location, int capacity, RegistrationDto[] registrations, String eventType){
        super();
        this.id = id;
        this.title = title;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
        this.registrations = registrations;
        this.eventType = eventType;
    }

}


