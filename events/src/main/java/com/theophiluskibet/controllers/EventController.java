package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.repository.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    EventsRepository eventsRepository;

    @PostMapping("event")
    public EventDto createEvent(@RequestBody EventDto incomingEvent) {
        return eventsRepository.save(incomingEvent);
    }

    @GetMapping("/event/{id}")
    public EventDto getEvent(@PathVariable("id") String eventId) {
        return eventsRepository.findById(eventId).orElseThrow();
    }

    @GetMapping("/events")
    public List<EventDto> getEvents() {
        return eventsRepository.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventsRepository.deleteById(id);
    }

    public EventController(@Autowired EventsRepository eventsRepository) {
        super();
        this.eventsRepository = eventsRepository;
    }
}


