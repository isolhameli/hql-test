package com.example.demo.exceptions;

public class StandardError {

    private String message;
    private Long timestamp;
    private String path;
    private Integer statusCode;

    public StandardError(String message, Long timestamp, String path, Integer statusCode) {
        this.message = message;
        this.timestamp = timestamp;
        this.path = path;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
