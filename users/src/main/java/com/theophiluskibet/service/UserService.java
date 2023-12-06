package com.theophiluskibet.service;

import com.theophiluskibet.models.entities.dtos.UserDto;
import com.theophiluskibet.models.entities.UserEntity;
import com.theophiluskibet.models.entities.mappers.UserMapper;
import com.theophiluskibet.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserEntity createUser(UserDto user) {
        if (user.userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        } else {
            return userRepository.insert(userMapper.userEntityFromUserDto(user));
        }
    }

    public Optional<UserEntity> getUser(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        } else {
            return userEntity;
        }
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity update(UserDto user, String userId) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("User with id " + userId + " not found");
        } else {
            return userRepository.save(userMapper.userEntityFromUserDto(user));
        }
    }

    public void deleteUser(String id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("User with id " + id + " not found");
        } else {
            userRepository.deleteById(id);
        }
    }
}
