package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.EventDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event")
    public EventDto getEvent(@RequestParam("id") String eventId) {
        return new EventDto();
    }

    @GetMapping("/events")
    public EventDto[] getEvents() {
        return new EventDto[]{ new EventDto() };
    }

}


