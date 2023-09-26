package com.theophiluskibet.repositories;

import com.theophiluskibet.dtos.AccessToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Stack;

@Repository
public interface PaymentRepository extends MongoRepository<AccessToken, String> {
}
