package com.theophiluskibet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theophiluskibet.dtos.AccessToken;
import com.theophiluskibet.dtos.InitiateStkPush;
import com.theophiluskibet.dtos.StkPushRequest;
import com.theophiluskibet.service.PaymentService;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

// TODO: 25/09/2023 cleanup and save token to db
@Component
public class ExternalApiCalls {

//    @Autowired
//    private PaymentService paymentService;

    private String authHeader;

    // TODO: 25/09/2023 change time to 1hr = 1000*60*60
    @Scheduled(fixedRate = 60 * 60 * 1000)
    private void getAccessToken() throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(Constants.accessTokenEndpoint)
                .addHeader("Authorization", Credentials.basic(Constants.consumerKey, Constants.consumerSecret))
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    ObjectMapper mapper = new ObjectMapper();
                    AccessToken accessToken = mapper.readValue(responseBody.string(), AccessToken.class);
                    // paymentService.saveAccessToken(accessToken);
                    authHeader = accessToken.getAccessToken();
                    System.out.println(accessToken);
                }
            }
        });
    }

    public void initiateStkPush(StkPushRequest stkPushRequest) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + authHeader);
        System.out.println(headers.get("Authorization"));
        System.out.println(stkPushRequest.getPassword());

        HttpEntity request = new HttpEntity(stkPushRequest, headers);

        ResponseEntity<Object> response = restTemplate.exchange("https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest", HttpMethod.POST, request, Object.class);

        System.out.println("STK RESPONSE" + response.getBody());
    }

}


