package com.theophiluskibet.grpc;

import com.theophiluskibet.users.UserServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class UsersClient {

    @GrpcClient("user")
    UserServiceGrpc.UserServiceBlockingStub client;

    public UserServiceGrpc.UserServiceBlockingStub getClient() {
        return client;
    }



    //    public User.UserResponse createUser(Users.UserRequest request) {
//
//        Users.UserRequest req= Users.UserRequest.newBuilder().setName(request.getName()).build();
//
//        return client.createUser(req);
//    }
}
