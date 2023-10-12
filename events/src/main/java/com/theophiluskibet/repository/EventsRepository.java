package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.entities.EventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends MongoRepository<EventEntity, String> {


}