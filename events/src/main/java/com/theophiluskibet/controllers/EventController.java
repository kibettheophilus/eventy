package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.service.EventsService;
import com.theophiluskibet.utilities.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    EventsService eventsService;

    @PostMapping("event")
    public ResponseEntity<Object> createEvent(@RequestBody EventDto incomingEvent) {
        try {
            EventDto result = eventsService.createEvent(incomingEvent);
            return ResponseHandler.respond(
                    "Event created successfully",
                    HttpStatus.CREATED,
                    result
            );
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Object> getEvent(@PathVariable("id") String eventId) {
        try {
            EventDto result = eventsService.getEvent(eventId);
            return ResponseHandler.respond(
                    "Event fetch successful",
                    HttpStatus.FOUND,
                    result
            );
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @GetMapping("/events")
    public ResponseEntity<Object> getEvents() {
        try {
            List<EventDto> result = List.of(eventsService.getEvents());
            return ResponseHandler.respond(
                    "Events fetch successful",
                    HttpStatus.OK,
                    result
            );
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("/event")
    public ResponseEntity<Object> updateEvent(@RequestBody EventDto eventDto) {
        try {
            EventDto result = eventsService.updateEvent(eventDto);
            return ResponseHandler.respond(
                    "Event updated successfully",
                    HttpStatus.OK,
                    result
            );
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @PutMapping("event/register")
    public ResponseEntity<Object> registerForEvent(@RequestBody RegistrationDto registration) {
        try {
            boolean isRegistrationSuccess = eventsService.registerForEvent(registration);
            if (isRegistrationSuccess) {
                return ResponseHandler.respond(
                        "You are going to this event!!",
                        HttpStatus.OK,
                        true
                );
            } else {
                return ResponseHandler.respond("Failed to register for event", HttpStatus.NOT_IMPLEMENTED, null);
            }

        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEvent(@PathVariable String id) {
        try {
            eventsService.deleteEvent(id);
            ;
            return ResponseHandler.respond(
                    "Event deleted successfully",
                    HttpStatus.OK,
                    null
            );
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    public EventController(@Autowired EventsService eventsService) {
        super();
        this.eventsService = eventsService;
    }
}


