package com.theophiluskibet.mappers;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.entities.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    EventDto eventEntityToEventDto(EventEntity eventEntity);

    EventEntity[] eventsToEntities(EventDto[] events);

    EventDto[] eventsToDtos(EventEntity[] events);

    EventEntity eventDtoToEntity(EventDto eventDto);

}
