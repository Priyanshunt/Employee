package com.springboot.demo.employee.v1.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Updation Request")
public class EmployeeUpdationRequest extends CommonRequest {

    @Schema(description = "Employee Id", minLength = 1, maxLength = 10, type = "Integer", example = "123")
    private Integer id;

    public EmployeeUpdationRequest() {
    }

    public EmployeeUpdationRequest(Integer id, String name, String department, String machine) {
        super(name, department, machine);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
