package com.theophiluskibet.dtos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    String id;
    String userName;
    String password;
    String email;

    String role;

    public User(String userName, String password, String email, String role){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
}