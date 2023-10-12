package com.theophiluskibet.mappers;

import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.entities.RegistrationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegistrationEntityMapper {

    RegistrationDto registrationDtoFromEntity(RegistrationEntity registrationEntity);
}
