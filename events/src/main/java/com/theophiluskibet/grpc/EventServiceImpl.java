package com.theophiluskibet.grpc;

import com.theophiluskibet.event.EventOuterClass;
import com.theophiluskibet.event.EventsServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EventServiceImpl extends EventsServiceGrpc.EventsServiceImplBase {
    @Override
    public void createEvent(EventOuterClass.Event request, StreamObserver<EventOuterClass.Event> responseObserver) {
        super.createEvent(request, responseObserver);

    }

    @Override
    public void getEvents(EventOuterClass.GetEvent request, StreamObserver<EventOuterClass.EventsReponse> responseObserver) {
        super.getEvents(request, responseObserver);
    }
}
