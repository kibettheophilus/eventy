package com.theophiluskibet.dtos;

import com.google.type.DateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("registration")
public class RegistrationDto {

    @Id
    public String id;

    public String username;

    public DateTime createdAt;

}
