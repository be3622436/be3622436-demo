package com.example.kracedemorocketmqproducer.entity;

import java.io.Serializable;

public class Response implements Serializable {

    private int statusCode;
    private String message;

    public Response() {
    }

    public Response(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}