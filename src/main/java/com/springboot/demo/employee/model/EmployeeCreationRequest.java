package com.springboot.demo.employee.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Employee Creation Request")
public class EmployeeCreationRequest {

    @Schema(description = "Employee Name", minLength = 1, maxLength = 40, type = "String", example = "Abc Def")
    private String name;
    @Schema(description = "Employee Department", minLength = 1, maxLength = 5, type = "String", example = "ABC")
    private String department;
    @Schema(description = "Employee Machine", minLength = 1, maxLength = 20, type = "String", example = "Windows")
    private String machine;

    public EmployeeCreationRequest() {
    }

    public EmployeeCreationRequest(String name, String department, String machine) {
        this.name = name;
        this.department = department;
        this.machine = machine;
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
