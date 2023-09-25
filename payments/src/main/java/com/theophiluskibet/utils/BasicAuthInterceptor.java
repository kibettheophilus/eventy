package com.theophiluskibet.utils;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class BasicAuthInterceptor implements Interceptor {
    private final String credentials;

    public BasicAuthInterceptor(String consumerKey, String consumerSecret) {
        this.credentials = Credentials.basic(consumerSecret, consumerSecret);
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        Request request = chain.request();
        Request aunthenticatedRequest = request.newBuilder().header("Authorization", credentials).build();
        return chain.proceed(aunthenticatedRequest);
    }
}
