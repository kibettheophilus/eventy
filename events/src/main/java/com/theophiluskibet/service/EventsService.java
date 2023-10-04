package com.theophiluskibet.service;

import com.theophiluskibet.dtos.EventDto;
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

    public EventDto updateEvent(EventDto eventDto){
        return eventsRepository.save(eventDto);
    }

    public void deleteEvent(String id) {
        eventsRepository.deleteById(id);
    }

    public boolean registerForEvent(){
        
    }

    public EventsService(EventsRepository eventsRepository){
        super();
        this.eventsRepository = eventsRepository;
    }
}
