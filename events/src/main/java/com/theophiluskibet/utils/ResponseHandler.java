package com.theophiluskibet.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> respond(String message, HttpStatus statusCode, Object responseObject) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", statusCode.value());
        map.put("data", responseObject);

        return new ResponseEntity<Object>(map, statusCode);
    }
}
