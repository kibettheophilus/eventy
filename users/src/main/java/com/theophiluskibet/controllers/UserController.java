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

    public UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        try {
            UserDto result = userService.createUser(userDto);
            return ResponseHandler.respond("", HttpStatus.CONFLICT, result);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") String userId) {
        try {
            UserDto user = userService.getUser(userId);
            return ResponseHandler.respond("", HttpStatus.CONFLICT, user);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.CONFLICT, null);
        }
    }

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

}
