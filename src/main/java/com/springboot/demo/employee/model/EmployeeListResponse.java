package com.springboot.demo.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Employee List Response")
public class EmployeeListResponse extends CommonResponse {

    @Schema(description = "Employee  List", type = "List<Employee>")
    private List<Employee> employeeList;

    public EmployeeListResponse() {
    }

    public EmployeeListResponse(Integer statusCode, String message, List<Employee> employeeList) {
        super(statusCode, message);
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
