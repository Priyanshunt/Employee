package com.springboot.demo.employee.service;

import com.springboot.demo.employee.model.*;

public interface EmployeeService {

    public EmployeeListResponse getAllEmployees();

    public EmployeeResponse getEmployeeById(Integer id);

    public EmployeeResponse addEmployee(EmployeeCreationRequest request);

    public EmployeeResponse updateEmployee(EmployeeUpdationRequest request);

    public EmployeeDeleteResponse deleteEmployeeById(Integer id);
}
