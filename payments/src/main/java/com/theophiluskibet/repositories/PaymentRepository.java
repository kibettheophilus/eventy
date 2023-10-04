package com.theophiluskibet.repositories;

import com.theophiluskibet.dtos.AccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Stack;

// TODO: 04/10/2023 Remove Access token since it is not being saved to db 
@Repository
public interface PaymentRepository extends MongoRepository<AccessToken, String> {
}
