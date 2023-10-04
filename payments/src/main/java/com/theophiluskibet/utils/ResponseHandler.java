package com.theophiluskibet.utils;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
public class ResponseHandler {
    private int code;
    private Boolean status;
    private String message;
    private Object data;
}
