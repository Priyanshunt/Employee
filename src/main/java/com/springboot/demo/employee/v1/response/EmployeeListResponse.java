package com.springboot.demo.employee.v1.response;

import com.springboot.demo.employee.repository.model.Employee;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Employee List Response")
public class EmployeeListResponse extends CommonResponse {

    @Schema(description = "Employee  List", type = "List<Employee>")
    private List<Employee> employeeList;

    public EmployeeListResponse() {
    }

    public EmployeeListResponse(Integer status, String message, List<Employee> employeeList) {
        super(status, message);
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
