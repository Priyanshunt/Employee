package com.springboot.demo.employee.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;

public class CommonResponse {

    @Schema(description = "Status", minLength = 3, maxLength = 3, type = "Integer", example = "200")
    private Integer status;
    @Schema(description = "Message", minLength = 1, maxLength = 200, type = "String", example = "Ok")
    private String message;
    @Schema(description = "Time Stamp", minLength = 1, maxLength = 20, type = "Long", example = "2147483647")
    private Long timeStamp;

    public CommonResponse() {
        this.timeStamp = System.currentTimeMillis();
    }

    public CommonResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
