package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.RegistrationDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationsRepository extends MongoRepository<RegistrationDto, String> {
}
