package com.theophiluskibet.mappers;

import com.theophiluskibet.dtos.UserDto;
import com.theophiluskibet.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userEntityFromUserDto(UserDto userDto);
}
