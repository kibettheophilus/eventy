package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.EventDto;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends MongoRepository<EventDto, EventDto> {

    EventDto getEventDtoById(String id);

    EventDto[] getAllByIdIs();

    EventDto updateEvent();

    void deleteEventDtoById(String id);


}

