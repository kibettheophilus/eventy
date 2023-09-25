package com.theophiluskibet;

import com.theophiluskibet.users.UserOuterClass;
import com.theophiluskibet.users.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void createUser(UserOuterClass.User request, StreamObserver<UserOuterClass.User> responseObserver) {
        super.createUser(request, responseObserver);
    }

    @Override
    public void updateUser(UserOuterClass.User request, StreamObserver<UserOuterClass.User> responseObserver) {
        super.updateUser(request, responseObserver);
    }
}

