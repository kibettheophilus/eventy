package com.theophiluskibet.dtos;

public class User {

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
