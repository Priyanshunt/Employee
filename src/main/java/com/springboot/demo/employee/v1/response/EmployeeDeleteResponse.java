package com.springboot.demo.employee.v1.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Deletion Response")
public class EmployeeDeleteResponse extends CommonResponse {

    @Schema(description = "Employee Id", type = "Integer", example = "123")
    private Integer id;

    public EmployeeDeleteResponse() {
    }

    public EmployeeDeleteResponse(Integer status, String message, Integer id) {
        super(status, message);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
