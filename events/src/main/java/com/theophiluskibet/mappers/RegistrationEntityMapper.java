package com.theophiluskibet.mappers;

import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.entities.RegistrationEntity;
import org.mapstruct.Mapper;

@Mapper
public interface RegistrationEntityMapper {

    RegistrationDto registrationEntityToRegistrationDto(RegistrationEntity registrationEntity);
}
