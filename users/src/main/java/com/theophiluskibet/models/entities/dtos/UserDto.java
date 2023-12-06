package com.theophiluskibet.models.entities.dtos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserDto {
    public String userName;
    public String password;
    public String email;
    public String role;
}
