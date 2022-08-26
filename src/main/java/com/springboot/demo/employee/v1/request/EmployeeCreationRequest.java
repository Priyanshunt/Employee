package com.springboot.demo.employee.v1.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Creation Request")
public class EmployeeCreationRequest extends CommonRequest {

    public EmployeeCreationRequest() {
    }

    public EmployeeCreationRequest(String name, String department, String machine) {
        super(name, department, machine);
    }
}
