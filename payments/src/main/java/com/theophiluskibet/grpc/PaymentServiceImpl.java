package com.theophiluskibet.grpc;

import com.theophiluskibet.payments.PaymentServiceGrpc;
import com.theophiluskibet.payments.Payments;
import com.theophiluskibet.service.PaymentService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class PaymentServiceImpl extends PaymentServiceGrpc.PaymentServiceImplBase {
    private PaymentService paymentService;

    // TODO: 25/09/2023 since this should be running as a scheduled task rather than an invoked by user, maybe remove from proto
    @Override
    public void getMpesaToken(Payments.MpesaAuthTokenRequest request, StreamObserver<Payments.MpesaAuthTokenResponse> responseObserver) {

    }

    @Override
    public void initiateMpesaStkPush(Payments.MpesaStkPushRequest request, StreamObserver<Payments.MpesaStkPushResponse> responseObserver) {

    }
}
