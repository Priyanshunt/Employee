package com.springboot.demo.employee.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

    @Test
    public void test() {
        Employee employee = new Employee();
        employee.setId(123);
        employee.setName("name");
        employee.setDepartment("dep");
        employee.setMachine("machine");

        assertNotNull(employee);
        assertEquals(123, employee.getId().intValue());
        assertEquals("name", employee.getName());
        assertEquals("dep", employee.getDepartment());
        assertEquals("machine", employee.getMachine());

        Employee employee1 = new Employee("name", "dep", "machine");
        employee1.setId(123);

        assertNotNull(employee1);
        assertTrue(new ReflectionEquals(employee).matches(employee1));
    }
}
