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

@Component
public class ExternalApiCalls {
    private String authHeader;

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


