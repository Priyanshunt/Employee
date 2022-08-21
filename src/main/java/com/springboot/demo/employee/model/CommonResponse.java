package com.springboot.demo.employee.model;

public class CommonResponse {

    private Integer statusCode;
    private String message;
    private Long timeStamp;

    public CommonResponse() {
    }

    public CommonResponse(Integer statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
