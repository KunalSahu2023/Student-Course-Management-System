package com.javaDeveloper.springbootapi.payload;

import lombok.Data;

import java.time.LocalDateTime;
@Data

public class ApiResponse <T> {
    private int code;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public ApiResponse() {
    }

    public ApiResponse(int code, String message, T data, LocalDateTime timestamp) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = timestamp;
    }


}
