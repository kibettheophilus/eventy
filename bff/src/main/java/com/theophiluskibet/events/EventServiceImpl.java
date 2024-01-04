package com.theophiluskibet.events;

import com.theophiluskibet.event.EventOuterClass;
import com.theophiluskibet.event.EventsServiceGrpc;
import com.theophiluskibet.graphql.types.EventInput;
import com.theophiluskibet.graphql.types.EventResponse;
import net.devh.boot.grpc.client.inject.GrpcClient;

public class EventServiceImpl implements EventService {

    EventsServiceGrpc.EventsServiceBlockingStub eventsClient;

    @GrpcClient("events-client")
    public void setEventsServiceBlockingStub(EventsServiceGrpc.EventsServiceBlockingStub eventsServiceBlockingStub) {
        this.eventsClient = eventsServiceBlockingStub;
    }

    @Override
    public EventResponse getEvents(EventInput input) {
        System.out.println(input);
        var response = eventsClient.getEvents(EventOuterClass.EventId.newBuilder().setId(input.getEventName()).build());
        return null;
    }
}
