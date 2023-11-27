package com.springboot.demo.employee.service.impl;

import com.springboot.demo.employee.exception.EmployeeNotFoundException;
import com.springboot.demo.employee.repository.EmployeeRepository;
import com.springboot.demo.employee.repository.model.Employee;
import com.springboot.demo.employee.service.EmployeeService;
import com.springboot.demo.employee.v1.request.EmployeeCreationRequest;
import com.springboot.demo.employee.v1.request.EmployeeUpdationRequest;
import com.springboot.demo.employee.v1.response.EmployeeDeleteResponse;
import com.springboot.demo.employee.v1.response.EmployeeListResponse;
import com.springboot.demo.employee.v1.response.EmployeeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Cacheable(value = "generic")
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
        employee = employeeRepository.save(employee);
        EmployeeResponse response = new EmployeeResponse(successStatus(),
                "Employee details has been added with id: " + employee.getId() + ".", employee);
        return response;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeUpdationRequest request) {
        Optional<Employee> employeeObject = employeeRepository.findById(request.getId());
        if (employeeObject.isEmpty())
            throw new EmployeeNotFoundException(request.getId());
        Employee employee = employeeObject.get();
        if (null != request.getName() && !"".equalsIgnoreCase(request.getDepartment())) {
            employee.setName(request.getName());
        }
        if (null != request.getDepartment() && !"".equalsIgnoreCase(request.getDepartment())) {
            employee.setDepartment(request.getDepartment());
        }
        if (null != request.getMachine() && !"".equalsIgnoreCase(request.getMachine())) {
            employee.setMachine(request.getMachine());
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
                "Employee details has been deleted with id: " + id + ".", id);
        return response;
    }

    private Employee generateEmployee(EmployeeCreationRequest request) {
        return new Employee(request.getName(), request.getDepartment(), request.getMachine());
    }

    private Integer successStatus() {
        return HttpStatus.OK.value();
    }
}
