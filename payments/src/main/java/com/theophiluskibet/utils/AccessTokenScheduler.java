package com.theophiluskibet.utils;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

// TODO: 25/09/2023 cleanup and save token to db
@Component
public class AccessTokenScheduler {

    // TODO: 25/09/2023 change time to 1hr = 1000*60*60 
    @Scheduled(fixedRate = 60 * 60)
    public void getAccessToken() {
        Request request = new Request.Builder().url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials").addHeader("Authorization", Credentials.basic("bWkjAdbz4wxma05DIsDQh4j1K79qMwAA", "iuOzK7K1fJV9BfFK")).build();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                System.out.println(response + " " + LocalDateTime.now());
            }
        });
    }

}


