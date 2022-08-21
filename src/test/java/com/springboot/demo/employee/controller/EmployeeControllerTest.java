package com.springboot.demo.employee.controller;

import com.springboot.demo.employee.model.*;
import com.springboot.demo.employee.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Test
    public void getAllEmployeesTest() {
        EmployeeListResponse response = new EmployeeListResponse(200, "message", new ArrayList<>());
        when(employeeService.getAllEmployees()).thenReturn(response);
        EmployeeListResponse response1 = employeeController.getAllEmployees();
        verify(employeeService, times(1)).getAllEmployees();
        assertEquals(200, response1.getStatusCode());
        assertEquals("message", response1.getMessage());
    }

    @Test
    public void getEmployeeByIdTest() {
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        Integer id = 123;
        when(employeeService.getEmployeeById(anyInt())).thenReturn(response);
        EmployeeResponse response1 = employeeController.getEmployeeById(id);
        verify(employeeService, times(1)).getEmployeeById(id);
        assertEquals(200, response1.getStatusCode());
        assertEquals("message", response1.getMessage());
    }

    @Test
    public void addEmployeeTest() {
        EmployeeCreationRequest request = new EmployeeCreationRequest();
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        when(employeeService.addEmployee(any(EmployeeCreationRequest.class))).thenReturn(response);
        EmployeeResponse response1 = employeeController.addEmployee(request);
        verify(employeeService, times(1)).addEmployee(request);
        assertEquals(200, response1.getStatusCode());
        assertEquals("message", response1.getMessage());
    }

    @Test
    public void updateEmployeeTest() {
        EmployeeUpdationRequest request = new EmployeeUpdationRequest();
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        when(employeeService.updateEmployee(any(EmployeeUpdationRequest.class))).thenReturn(response);
        EmployeeResponse response1 = employeeController.updateEmployee(request);
        verify(employeeService, times(1)).updateEmployee(request);
        assertEquals(200, response1.getStatusCode());
        assertEquals("message", response1.getMessage());
    }

    @Test
    public void deleteEmployeeByIdTest() {
        EmployeeDeleteResponse response = new EmployeeDeleteResponse(200, "message", null);
        Integer id = 123;
        when(employeeService.deleteEmployeeById(anyInt())).thenReturn(response);
        EmployeeDeleteResponse response1 = employeeController.deleteEmployeeById(id);
        verify(employeeService, times(1)).deleteEmployeeById(id);
        assertEquals(200, response1.getStatusCode());
        assertEquals("message", response1.getMessage());
    }
}
