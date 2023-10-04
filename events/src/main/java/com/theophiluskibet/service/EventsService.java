package com.theophiluskibet.service;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.repository.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public boolean registerForEvent(RegistrationDto registration) {
        try {
            EventDto event = eventsRepository.findById(registration.eventId).orElseThrow();
            RegistrationDto[] registrations = addRegistration(event.registrations, registration);
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

        List<RegistrationDto> registrationsList = new ArrayList<RegistrationDto>(Arrays.asList(registrations));

        registrationsList.add(userRegistration);

        registrations = registrationsList.toArray(registrations);

        return registrations;
    }
}
