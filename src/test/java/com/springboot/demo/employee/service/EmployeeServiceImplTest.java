package com.springboot.demo.employee.service;

import com.springboot.demo.employee.dao.EmployeeDAO;
import com.springboot.demo.employee.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeDAO employeeDAO;

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
        when(employeeDAO.getAllEmployees()).thenReturn(employees);
        List<Employee> employeeList = employeeServiceImpl.getAllEmployees();
        assertEquals(123, employeeList.get(0).getId());
        assertEquals(456, employeeList.get(1).getId());
    }

    @Test
    public void getEmployeeByIdTest() {
        Employee employee = new Employee();
        employee.setId(123);
        when(employeeDAO.getEmployeeById(anyInt())).thenReturn(employee);
        Employee employee1 = employeeServiceImpl.getEmployeeById(123);
        assertTrue(new ReflectionEquals(employee).matches(employee1));
    }

    @Test
    public void saveEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(0);
        doNothing().when(employeeDAO).saveEmployee(any(Employee.class));
        String message = employeeServiceImpl.saveEmployee(employee);
        assertEquals("Employee Details has been saved", message);
    }

    @Test
    public void updateEmployeeTest() {
        Employee employee = new Employee();
        employee.setId(123);
        doNothing().when(employeeDAO).updateEmployee(any(Employee.class));
        String message = employeeServiceImpl.updateEmployee(employee);
        assertEquals("Employee Details has been updated", message);
    }

    @Test
    public void deleteEmployeeByIdTest() {
        doNothing().when(employeeDAO).deleteEmployeeById(anyInt());
        String message = employeeServiceImpl.deleteEmployeeById(123);
        assertEquals("Employee Details has been deleted", message);
    }
}
