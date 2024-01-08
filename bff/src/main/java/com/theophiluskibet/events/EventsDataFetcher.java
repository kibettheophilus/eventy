package com.theophiluskibet.events;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.theophiluskibet.graphql.types.EventInput;
import com.theophiluskibet.graphql.types.EventResponse;
import lombok.RequiredArgsConstructor;

@DgsComponent
@RequiredArgsConstructor
public class EventsDataFetcher {
    EventService eventService;

    @DgsQuery
    public EventResponse getEvents(@InputArgument EventInput input) {
        System.out.println(input);
        return null;
    }
}
