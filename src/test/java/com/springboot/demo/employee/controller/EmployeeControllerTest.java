package com.springboot.demo.employee.controller;

import com.springboot.demo.employee.model.Employee;
import com.springboot.demo.employee.model.EmployeeResponse;
import com.springboot.demo.employee.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    List<Employee> employees;

    @Before
    public void before() {
        employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(123);
        employees.add(employee);
        employee = new Employee();
        employee.setId(456);
        employees.add(employee);
    }

    @Test
    public void getAllEmployeesTest() {
        when(employeeService.getAllEmployees()).thenReturn(employees);
        List<Employee> employeeList = employeeController.getAllEmployees();
        verify(employeeService, times(1)).getAllEmployees();
        assertEquals(123, employeeList.get(0).getId());
        assertEquals(456, employeeList.get(1).getId());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(employeeService.getEmployeeById(anyInt())).thenReturn(employees.get(0));
        ResponseEntity<EmployeeResponse> responseEntity = employeeController.getEmployeeById(123);
        verify(employeeService, times(1)).getEmployeeById(123);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void addEmployeeTest() {
        Employee employee1 = new Employee();
        employee1.setId(789);
        ResponseEntity<EmployeeResponse> responseEntity = employeeController.addEmployee(employee1);
        verify(employeeService, times(1)).saveEmployee(employee1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void updateEmployeeTest() {
        Employee employee1 = new Employee();
        employee1.setId(456);
        employee1.setName("name");
        when(employeeService.getEmployeeById(anyInt())).thenReturn(employees.get(1));
        ResponseEntity<EmployeeResponse> responseEntity = employeeController.updateEmployee(employee1);
        verify(employeeService, times(1)).updateEmployee(employee1);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void deleteEmployeeByIdTest() {
        when(employeeService.getEmployeeById(anyInt())).thenReturn(employees.get(1));
        ResponseEntity<Map<String, Object>> responseEntity = employeeController.deleteEmployeeById(456);
        verify(employeeService, times(1)).deleteEmployeeById(456);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
