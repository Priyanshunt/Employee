package com.springboot.demo.account.service;

import com.springboot.demo.account.dao.EmployeeDAO;
import com.springboot.demo.account.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public String saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
        return "Employee Details has been saved";
    }

    @Override
    @Transactional
    public String updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
        return "Employee Details has been saved";
    }

    @Override
    @Transactional
    public String deleteById(int id) {
        employeeDAO.deleteById(id);
        return "Employee Details has been deleted";
    }
}
