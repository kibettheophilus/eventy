package com.theophiluskibet;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import users.UserServiceGrpc;
import users.Users;

@Service
public class UsersClient {

    @GrpcClient("user")
    UserServiceGrpc.UserServiceBlockingStub client;

    public Users.UserResponse createUser(Users.UserRequest request) {

        Users.UserRequest req= Users.UserRequest.newBuilder().setName(request.getName()).build();

        return client.createUser(req);
    }
}
