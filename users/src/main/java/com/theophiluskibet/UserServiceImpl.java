package com.theophiluskibet;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import users.UserServiceGrpc;
import users.Users;

@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {
    @Override
    public void createUser(Users.UserRequest request, StreamObserver<Users.UserResponse> responseObserver) {

    }
}
