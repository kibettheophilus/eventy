package com.theophiluskibet;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import users.UserServiceGrpc;
import users.Users;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void createUser(Users.UserRequest request, StreamObserver<Users.UserResponse> responseObserver) {
        Users.UserRequest user = Users.UserRequest.newBuilder().setId(request.getId()).setName(request.getName()).build();

        Users.UserResponse response = Users.UserResponse.newBuilder().setId(user.getId()).setName(user.getName()).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}

