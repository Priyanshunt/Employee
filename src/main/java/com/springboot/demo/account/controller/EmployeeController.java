package com.springboot.demo.account.controller;

import com.springboot.demo.account.entity.Employee;
import com.springboot.demo.account.entity.EmployeeResponse;
import com.springboot.demo.account.exception.EmployeeNotFoundException;
import com.springboot.demo.account.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " is not found.");

        EmployeeResponse response = new EmployeeResponse(
                "Employee with id: " + employee.getId() + " has been found.", employee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody Employee employee) {

        employee.setId(0);

        String message = employeeService.saveEmployee(employee);

        EmployeeResponse response = new EmployeeResponse(message + " with id: " + employee.getId() + ".", employee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody Employee employee) {

        if (employeeService.getEmployeeById(employee.getId()) == null)
            throw new EmployeeNotFoundException("Employee with id: " + employee.getId() + " is not found.");

        String message = employeeService.updateEmployee(employee);

        EmployeeResponse response = new EmployeeResponse(
                message + " with id: " + employee.getId() + ".", employee);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Object>> deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployeeById(id);

        if (employee == null)
            throw new EmployeeNotFoundException("Employee with id: " + id + " is not found.");

        String message = employeeService.deleteById(id);

        EmployeeResponse response = new EmployeeResponse(
                message + " with id: " + id + ".");

        Map<String,Object> responseMap=new HashMap<>();

        responseMap.put("timeStamp", response.getTimeStamp());

        responseMap.put("message", response.getMessage());

        responseMap.put("status", response.getStatus());

        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
