package com.springboot.demo.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Response")
public class EmployeeResponse extends CommonResponse {

    @Schema(description = "Employee Object", type = "Employee")
    private Employee employee;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Integer statusCode, String message, Employee employee) {
        super(statusCode, message);
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
