package com.example.quizapp.payload;

public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    // Constructor, Getters and Setters
    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}