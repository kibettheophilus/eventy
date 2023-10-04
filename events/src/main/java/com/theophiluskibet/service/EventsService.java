package com.theophiluskibet.service;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.repository.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    EventsRepository eventsRepository;

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
            EventDto event = eventsRepository.findById(eventId).orElseThrow();
            RegistrationDto[] registrations = addRegistration(event.registrations, new RegistrationDto(attendeeName, "", eventId));
            EventDto eventToSave = new EventDto(event.id, event.title, event.date, event.location, event.capacity, registrations, event.eventType);
            eventsRepository.save(eventToSave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EventsService(EventsRepository eventsRepository) {
        super();
        this.eventsRepository = eventsRepository;
    }

    private RegistrationDto[] addRegistration(RegistrationDto[] registrations, RegistrationDto userRegistration) {

        int index;
        RegistrationDto[] newRegistrations = new RegistrationDto[registrations.length + 1];

        for (index = 0; index < registrations.length; index++) {
            newRegistrations[index] = registrations[index];
        }
        newRegistrations[registrations.length + 1] = userRegistration;

        return newRegistrations;
    }
}
