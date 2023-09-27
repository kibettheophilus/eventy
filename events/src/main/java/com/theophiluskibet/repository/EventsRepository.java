package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.EventDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends MongoRepository<EventDto, String> {

    EventDto save(@NonNull EventDto eventDto);

    EventDto getEventDtoById(String id);

    boolean existsById(@NonNull String id);

    @NonNull
    List<EventDto> findAll();

    void deleteEventDtoById(String id);

}

