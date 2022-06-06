package com.springboot.demo.account.dao;

import com.springboot.demo.account.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int id);

    public void saveEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployeeById(int id);
}
