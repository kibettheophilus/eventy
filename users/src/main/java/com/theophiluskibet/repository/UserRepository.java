package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.UserDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDto, String> {
}
