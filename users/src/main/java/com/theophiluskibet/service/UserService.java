package com.theophiluskibet.service;

import com.theophiluskibet.dtos.UserDto;
import com.theophiluskibet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserDto createUser(UserDto user){
        return userRepository.insert(user);
    }

    public UserDto getUser(String id){
        return userRepository.findById(id).orElseThrow();
    }

    public List<UserDto> getUsers(){
        return userRepository.findAll();
    }

    public UserDto update(UserDto user){
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
