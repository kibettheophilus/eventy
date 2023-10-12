package com.theophiluskibet.service;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.entities.EventEntity;
import com.theophiluskibet.mappers.EventMapper;
import com.theophiluskibet.repository.EventsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventsService {

    EventsRepository eventsRepository;
    EventMapper eventMapper;

    public EventDto createEvent(EventDto incomingEvent) {
        EventEntity eventEntity = eventsRepository.save(eventMapper.eventDtoToEntity(incomingEvent));
        return eventMapper.eventEntityToEventDto(eventEntity);
    }

    public EventDto getEvent(String eventId) {
        return eventMapper.eventEntityToEventDto(eventsRepository.findById(eventId).orElseThrow());
    }

    public EventDto[] getEvents() {
        var eventsFromDb = eventsRepository.findAll();
        EventEntity[] eventDtos = new EventEntity[eventsFromDb.size()];
        return eventMapper.eventsToDtos(eventDtos);
    }

    public EventDto updateEvent(EventDto eventDto) {
        var savedEvent = eventsRepository.save(eventMapper.eventDtoToEntity(eventDto));
        return eventMapper.eventEntityToEventDto(savedEvent);
    }

    public void deleteEvent(String id) {
        eventsRepository.deleteById(id);
    }

    public boolean registerForEvent(RegistrationDto registration) {
        try {
            EventDto event = getEvent(registration.eventId);
            RegistrationDto[] registrations = addRegistration(event.registrations, registration);
            EventDto eventToSave = new EventDto(event.id, event.title, event.date, event.location, event.capacity, registrations, event.eventType);
            updateEvent(eventToSave);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EventsService(EventsRepository eventsRepository, EventMapper eventMapper) {
        super();
        this.eventsRepository = eventsRepository;
        this.eventMapper = eventMapper;
    }

    private RegistrationDto[] addRegistration(RegistrationDto[] registrations, RegistrationDto userRegistration) {

        List<RegistrationDto> registrationsList = new ArrayList<>(Arrays.asList(registrations));

        registrationsList.add(userRegistration);

        registrations = registrationsList.toArray(registrations);

        return registrations;
    }
}
