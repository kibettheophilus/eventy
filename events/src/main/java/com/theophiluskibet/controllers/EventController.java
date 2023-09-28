package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventsRepository eventsRepository;

    @GetMapping("/event")
    public EventDto getEvent(@RequestParam("id") String eventId) {
        return eventsRepository.getEventDtoById(eventId);
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventsRepository.findAll();
    }
}


