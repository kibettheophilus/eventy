package com.theophiluskibet.grpc;

import com.theophiluskibet.dtos.EventDto;
import com.theophiluskibet.dtos.RegistrationDto;
import com.theophiluskibet.event.EventOuterClass;
import com.theophiluskibet.event.EventsServiceGrpc;
import com.theophiluskibet.repository.EventsRepository;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Array;
import java.util.Date;

@GrpcService
public class EventServiceImpl extends EventsServiceGrpc.EventsServiceImplBase {

    @Autowired
    private EventsRepository eventsRepository;

    //TODO: Create mapper to map request to Event dto

    @Override
    public void createEvent(EventOuterClass.Event request, StreamObserver<EventOuterClass.Event> responseObserver) {
//        eventsRepository.save();
    }

    @Override
    public void getEvents(EventOuterClass.EventId request, StreamObserver<EventOuterClass.EventsResponse> responseObserver) {
        eventsRepository.findAll();
    }
}
