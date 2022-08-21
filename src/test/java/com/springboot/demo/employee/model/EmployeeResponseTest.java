package com.springboot.demo.employee.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResponseTest {

    @Test
    public void test() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("name");
        employee.setDepartment("dep");
        employee.setMachine("machine");

        EmployeeResponse response = new EmployeeResponse();
        long timeStamp = System.currentTimeMillis();
        response.setStatusCode(200);
        response.setMessage("message");
        response.setTimeStamp(timeStamp);
        response.setEmployee(employee);

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().intValue());
        assertEquals("message", response.getMessage());
        assertEquals(timeStamp, response.getTimeStamp().longValue());
        assertTrue(new ReflectionEquals(response.getEmployee()).matches(employee));

        EmployeeResponse response1 = new EmployeeResponse(200, "message", employee);
        response1.setTimeStamp(timeStamp);

        assertNotNull(response1);
        assertTrue(new ReflectionEquals(response).matches(response1));
    }
}
