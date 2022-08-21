package com.springboot.demo.employee.service;

import com.springboot.demo.employee.model.*;
import com.springboot.demo.employee.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    public void getAllEmployeesTest() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(123);
        employees.add(employee);
        employee = new Employee();
        employee.setId(456);
        employees.add(employee);
        when(employeeRepository.findAll()).thenReturn(employees);
        EmployeeListResponse response = employeeServiceImpl.getAllEmployees();
        assertEquals(2, response.getEmployeeList().size());
        assertEquals(123, response.getEmployeeList().get(0).getId());
        assertEquals(456, response.getEmployeeList().get(1).getId());
        assertEquals(200, response.getStatusCode());
        assertEquals("Employee List has been retrieved.", response.getMessage());
    }

    @Test
    public void getEmployeeByIdTest() {
        Employee employee = new Employee();
        employee.setId(123);
        when(employeeRepository.findById(123)).thenReturn(Optional.of(employee));
        EmployeeResponse response = employeeServiceImpl.getEmployeeById(123);
        assertEquals(123, response.getEmployee().getId());
        assertEquals(200, response.getStatusCode());
        assertEquals("Employee with id: 123 has been found.", response.getMessage());
    }

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(123);
        EmployeeCreationRequest request = new EmployeeCreationRequest();
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeResponse response = employeeServiceImpl.addEmployee(request);
        assertEquals(123, response.getEmployee().getId());
        assertEquals(200, response.getStatusCode());
        assertEquals("Employee details has been saved with id: 123.", response.getMessage());
    }

    @Test
    public void updateEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(123);
        when(employeeRepository.findById(123)).thenReturn(Optional.of(employee));
        EmployeeUpdationRequest request = new EmployeeUpdationRequest();
        request.setId(123);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        EmployeeResponse response = employeeServiceImpl.updateEmployee(request);
        assertEquals(123, response.getEmployee().getId());
        assertEquals(200, response.getStatusCode());
        assertEquals("Employee details has been updated with id: 123.", response.getMessage());
    }

    @Test
    public void deleteEmployeeByIdTest() {
        Employee employee = new Employee();
        employee.setId(123);
        when(employeeRepository.findById(123)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepository).deleteById(anyInt());
        EmployeeDeleteResponse response = employeeServiceImpl.deleteEmployeeById(123);
        assertEquals(123, response.getId());
        assertEquals(200, response.getStatusCode());
        assertEquals("Employee details has been updated with id: 123.", response.getMessage());
    }
}
