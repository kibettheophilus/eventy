package com.theophiluskibet.grpc;

import com.theophiluskibet.event.EventOuterClass;
import com.theophiluskibet.event.EventsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.lang.reflect.Array;

@GrpcService
public class EventServiceImpl extends EventsServiceGrpc.EventsServiceImplBase {
    @Override
    public void createEvent(EventOuterClass.Event request, StreamObserver<EventOuterClass.Event> responseObserver) {
        super.createEvent(request, responseObserver);

    }

    @Override
    public void getEvents(EventOuterClass.EventId request, StreamObserver<EventOuterClass.EventsResponse> responseObserver) {
        super.getEvents(request, responseObserver);
    }
}
