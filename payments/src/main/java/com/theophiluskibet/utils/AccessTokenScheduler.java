package com.theophiluskibet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theophiluskibet.dtos.AccessToken;
import com.theophiluskibet.service.PaymentService;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

// TODO: 25/09/2023 cleanup and save token to db
@Component
public class AccessTokenScheduler {

    @Autowired
    private PaymentService paymentService;

    // TODO: 25/09/2023 change time to 1hr = 1000*60*60
    @Scheduled(fixedRate = 60 * 60)
    public void getAccessToken() throws IOException {
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
                    paymentService.saveAccessToken(accessToken);
                    System.out.println(accessToken);
                }
            }
        });
    }

}


