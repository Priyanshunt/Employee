package com.springboot.demo.employee.exception;

import com.springboot.demo.employee.model.CommonResponse;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Error Response")
public class EmployeeErrorResponse extends CommonResponse {

    private String details;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(Integer statusCode, String details, String message) {
        super(statusCode, message);
        this.details = details;

    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
