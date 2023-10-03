package com.theophiluskibet.utils;


import lombok.Data;

@Data
public class ResponseHandler {
    public String code;
    public Boolean success;
    public String message;
    public Object data;
}
