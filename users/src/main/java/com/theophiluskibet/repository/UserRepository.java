package com.theophiluskibet.repository;

import com.theophiluskibet.dtos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
