package com.theophiluskibet.controllers;

import com.theophiluskibet.dtos.UserDto;
import com.theophiluskibet.repository.UserRepository;
import com.theophiluskibet.service.UserService;
import com.theophiluskibet.utilities.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository userRepository;
    public UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        try{
            UserDto result = userService.createUser(userDto);
            return ResponseHandler.respond("", HttpStatus.CONFLICT, result);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @GetMapping("/user/{id}")
    public UserDto getUserById(@PathVariable("id") String eventId){

    }

    public UserController(UserRepository userRepository, UserService userService) {
        super();
        this.userRepository = userRepository;
        this.userService = userService;
    }

}
