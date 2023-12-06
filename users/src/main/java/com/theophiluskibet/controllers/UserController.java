package com.theophiluskibet.controllers;

import com.theophiluskibet.models.entities.dtos.UserDto;
import com.theophiluskibet.models.entities.UserEntity;
import com.theophiluskibet.service.UserService;
import com.theophiluskibet.utilities.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        try {
            UserEntity result = userService.createUser(userDto);
            return ResponseHandler.respond("User created successfully", HttpStatus.CREATED, result);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable("id") String userId) {
        try {
            Optional<UserEntity> user = userService.getUser(userId);
            return ResponseHandler.respond("User fetched successfully", HttpStatus.OK, user);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PatchMapping("/user/{id}")
    public ResponseEntity<Object> updateUserById(
            @PathVariable("id") String userId,
            @RequestBody UserDto userDto
    ) {
        try {
            UserEntity user = userService.update(userDto, userId);
            return ResponseHandler.respond("User updated successfully", HttpStatus.OK, user);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getUsers() {
        try {
            List<UserEntity> users = userService.getUsers();
            System.out.println(users);
            return ResponseHandler.respond("Users fetched successfully", HttpStatus.OK, users);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") String userId) {
        try {
            userService.deleteUser(userId);
            return ResponseHandler.respond("User deleted successfully", HttpStatus.OK, null);
        } catch (Exception exception) {
            return ResponseHandler.respond(exception.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}
