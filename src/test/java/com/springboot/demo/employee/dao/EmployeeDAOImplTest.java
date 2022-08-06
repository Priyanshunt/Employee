package com.springboot.demo.employee.dao;

import com.springboot.demo.employee.model.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOImplTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private EmployeeDAOImpl employeeDAOImpl;

    private Query<Employee> query;

    private Session currentSession;

    private List<Employee> employees;

    @Before
    public void before() {
        employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(123);
        employees.add(employee);
        employee = new Employee();
        employee.setId(456);
        employees.add(employee);
        query = mock(Query.class);
        currentSession = mock(Session.class);
    }

    @Test
    public void getAllEmployeesTest() {
        when(entityManager.unwrap(eq(Session.class))).thenReturn(currentSession);
        when(currentSession.createQuery(anyString(), eq(Employee.class))).thenReturn(query);
        when(query.getResultList()).thenReturn(employees);
        List<Employee> employeeList = employeeDAOImpl.getAllEmployees();
        assertEquals(123, employeeList.get(0).getId());
        assertEquals(456, employeeList.get(1).getId());
    }

    @Test
    public void getEmployeeByIdTest() {
        when(entityManager.unwrap(eq(Session.class))).thenReturn(currentSession);
        when(currentSession.get(eq(Employee.class), anyInt())).thenReturn(employees.get(0));
        Employee employee1 = employeeDAOImpl.getEmployeeById(123);
        assertTrue(new ReflectionEquals(employees.get(0)).matches(employee1));
    }

    @Test
    public void saveEmployeeTest() {
        when(entityManager.unwrap(eq(Session.class))).thenReturn(currentSession);
        when(currentSession.save(any(Employee.class))).thenReturn(null);
        Employee employee1 = new Employee();
        employee1.setId(0);
        employeeDAOImpl.saveEmployee(employee1);
    }

    @Test
    public void updateEmployeeTest() {
        when(entityManager.unwrap(eq(Session.class))).thenReturn(currentSession);
        when(currentSession.merge(any(Employee.class))).thenReturn(null);
        Employee employee1 = new Employee();
        employee1.setId(123);
        employeeDAOImpl.updateEmployee(employee1);
    }

    @Test
    public void deleteEmployeeByIdTest() {
        when(entityManager.unwrap(eq(Session.class))).thenReturn(currentSession);
        when(currentSession.createQuery(anyString())).thenReturn(query);
        when(query.setParameter(anyString(), anyInt())).thenReturn(null);
        when(query.executeUpdate()).thenReturn(anyInt());
        employeeDAOImpl.deleteEmployeeById(123);
    }
}