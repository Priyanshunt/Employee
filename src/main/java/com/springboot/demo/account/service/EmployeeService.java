package com.springboot.demo.account.service;

import com.springboot.demo.account.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public String saveEmployee(Employee employee);

    public String updateEmployee(Employee employee);

    public String deleteEmployeeById(int id);
}
