package com.indiabulls.springbootapi.entity;

import java.time.LocalDateTime;

public class Response {
    private int code;
    private String message;
    private City data;
    private LocalDateTime timestamp;

    public Response() {
    }

    public Response(int code, String message, City data, LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public City getData() {
        return data;
    }

    public void setData(City data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
