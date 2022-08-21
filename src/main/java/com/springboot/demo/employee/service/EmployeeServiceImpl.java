package com.springboot.demo.employee.service;

import com.springboot.demo.employee.exception.EmployeeNotFoundException;
import com.springboot.demo.employee.model.*;
import com.springboot.demo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeListResponse getAllEmployees() {
        List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
        EmployeeListResponse response = new EmployeeListResponse(successStatus(),
                "Employee List has been retrieved.", employeeList);
        return response;
    }

    @Override
    public EmployeeResponse getEmployeeById(Integer id) {
        Optional<Employee> employeeObject = employeeRepository.findById(id);
        if (employeeObject.isEmpty())
            throw new EmployeeNotFoundException(id);
        Employee employee = employeeObject.get();
        EmployeeResponse response = new EmployeeResponse(successStatus(),
                "Employee with id: " + employee.getId() + " has been found.", employee);
        return response;
    }

    @Override
    public EmployeeResponse addEmployee(EmployeeCreationRequest request) {
        Employee employee = this.generateEmployee(request);
        employee.setId(0);
        employee = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse(successStatus(),
                "Employee details has been saved with id: " + employee.getId() + ".", employee);
        return response;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeUpdationRequest request) {
        Optional<Employee> employeeObject = employeeRepository.findById(request.getId());
        if (employeeObject.isEmpty())
            throw new EmployeeNotFoundException(request.getId());
        Employee employee = employeeObject.get();
        Employee updatedEmployee = this.generateEmployee(request);
        if (Objects.nonNull(updatedEmployee.getName()) && !"".equalsIgnoreCase(updatedEmployee.getName())) {
            updatedEmployee.setName(employee.getName());
        }
        if (Objects.nonNull(updatedEmployee.getDepartment()) && !"".equalsIgnoreCase(updatedEmployee.getDepartment())) {
            updatedEmployee.setDepartment(employee.getDepartment());
        }
        if (Objects.nonNull(updatedEmployee.getMachine()) && !"".equalsIgnoreCase(updatedEmployee.getMachine())) {
            updatedEmployee.setMachine(employee.getMachine());
        }
        employee = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse(successStatus(),
                "Employee details has been updated with id: " + employee.getId() + ".", employee);
        return response;
    }

    @Override
    public EmployeeDeleteResponse deleteEmployeeById(Integer id) {
        Optional<Employee> employeeObject = employeeRepository.findById(id);
        if (employeeObject.isEmpty())
            throw new EmployeeNotFoundException(id);
        employeeRepository.deleteById(id);
        EmployeeDeleteResponse response = new EmployeeDeleteResponse(successStatus(),
                "Employee details has been updated with id: " + id + ".", id);
        return response;
    }

    private Employee generateEmployee(EmployeeCreationRequest request) {
        return new Employee(request.getName(), request.getDepartment(), request.getMachine());
    }

    private Employee generateEmployee(EmployeeUpdationRequest request) {
        return new Employee(request.getId(), request.getName(), request.getDepartment(), request.getMachine());
    }

    private Integer successStatus() {
        return HttpStatus.OK.value();
    }
}
