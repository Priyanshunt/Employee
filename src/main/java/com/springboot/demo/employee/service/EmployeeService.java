package com.springboot.demo.employee.service;

import com.springboot.demo.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployeeById(int id);
}
