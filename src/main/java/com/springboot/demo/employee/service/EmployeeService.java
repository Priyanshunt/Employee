package com.springboot.demo.employee.service;

import com.springboot.demo.employee.v1.request.EmployeeCreationRequest;
import com.springboot.demo.employee.v1.request.EmployeeUpdationRequest;
import com.springboot.demo.employee.v1.response.EmployeeDeleteResponse;
import com.springboot.demo.employee.v1.response.EmployeeListResponse;
import com.springboot.demo.employee.v1.response.EmployeeResponse;

public interface EmployeeService {

    public EmployeeListResponse getAllEmployees();

    public EmployeeResponse getEmployeeById(Integer id);

    public EmployeeResponse addEmployee(EmployeeCreationRequest request);

    public EmployeeResponse updateEmployee(EmployeeUpdationRequest request);

    public EmployeeDeleteResponse deleteEmployeeById(Integer id);
}
