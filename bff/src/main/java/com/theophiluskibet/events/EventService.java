package com.theophiluskibet.events;


import com.theophiluskibet.graphql.types.EventInput;
import com.theophiluskibet.graphql.types.EventResponse;
import org.springframework.stereotype.Service;

interface EventService {
    EventResponse getEvents(EventInput input);
}
