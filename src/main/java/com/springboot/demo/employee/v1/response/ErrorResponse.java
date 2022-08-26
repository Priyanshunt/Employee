package com.springboot.demo.employee.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Error Response")
public class ErrorResponse extends CommonResponse {

    private String details;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message, String details) {
        super(status, message);
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
