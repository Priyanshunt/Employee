package com.springboot.demo.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Updation Request")
public class EmployeeUpdationRequest {

    @Schema(description = "Employee Id", minLength = 1, maxLength = 10, type = "Integer", example = "123")
    private Integer id;
    @Schema(description = "Employee Name", minLength = 0, maxLength = 40, type = "String", example = "Abc Def")
    private String name;
    @Schema(description = "Employee Department", minLength = 0, maxLength = 5, type = "String", example = "ABC")
    private String department;
    @Schema(description = "Employee Machine", minLength = 0, maxLength = 20, type = "String", example = "Windows")
    private String machine;

    public EmployeeUpdationRequest() {
    }

    public EmployeeUpdationRequest(Integer id, String name, String department, String machine) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.machine = machine;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }
}
