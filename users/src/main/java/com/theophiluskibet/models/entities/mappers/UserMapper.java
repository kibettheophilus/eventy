package com.theophiluskibet.models.entities.mappers;

import com.theophiluskibet.models.entities.dtos.UserDto;
import com.theophiluskibet.models.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity userEntityFromUserDto(UserDto userDto);
}
