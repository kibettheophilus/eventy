package com.theophiluskibet.service;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.event.EventOuterClass;
import com.theophiluskibet.repository.EventsRepository;
import com.theophiluskibet.repository.RegistrationsRepository;
import jdk.jshell.EvalException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    EventsRepository eventsRepository;
    RegistrationsRepository registrationsRepository;

    public EventDto createEvent(EventDto incomingEvent) {
        return eventsRepository.save(incomingEvent);
    }

    public EventDto getEvent(String eventId) {
        return eventsRepository.findById(eventId).orElseThrow();
    }

    public List<EventDto> getEvents() {
        return eventsRepository.findAll();
    }

    public EventDto updateEvent(EventDto eventDto) {
        return eventsRepository.save(eventDto);
    }

    public void deleteEvent(String id) {
        eventsRepository.deleteById(id);
    }

    public boolean registerForEvent(String eventId, String attendeeName) {
        try {
            registrationsRepository.insert(new RegistrationDto(attendeeName, "", eventId));
            EventDto event = eventsRepository.findById(eventId).orElseThrow();
            EventDto eventToSave = new EventDto(event.id, event.title, event.date, event.location, event.capacity, event.registrations, event.eventType);
            eventsRepository.save(eventToSave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EventsService(EventsRepository eventsRepository, RegistrationsRepository registrationsRepository) {
        super();
        this.eventsRepository = eventsRepository;
        this.registrationsRepository = registrationsRepository;
    }
}
