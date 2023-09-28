package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.EventDto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends MongoRepository<EventDto, String> {}