package com.springboot.demo.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Deletion Response")
public class EmployeeDeleteResponse extends CommonResponse {

    @Schema(description = "Employee Id", type = "Integer", example = "123")
    private Integer id;

    public EmployeeDeleteResponse() {
    }

    public EmployeeDeleteResponse(Integer statusCode, String message, Integer id) {
        super(statusCode, message);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
