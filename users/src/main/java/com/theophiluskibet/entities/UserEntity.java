package com.theophiluskibet.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("users")
public class UserEntity {
    @Id
    String id;
    String userName;
    String password;
    String email;

    String role;
    LocalDateTime dateCreated = LocalDateTime.now();

    public UserEntity(String userName, String password, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}
