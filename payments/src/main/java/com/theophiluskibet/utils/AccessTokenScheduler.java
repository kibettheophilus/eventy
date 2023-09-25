package com.theophiluskibet.utils;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccessTokenScheduler {

    private OkHttpClient okHttpClient;

    @Scheduled(fixedRate = 1000 * 60 * 60)
    public void getAccessToken() {
        Request request = new Request.Builder().url("").addHeader("Authorization", Credentials.basic("", "")).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {

            }
        });
    }

}


