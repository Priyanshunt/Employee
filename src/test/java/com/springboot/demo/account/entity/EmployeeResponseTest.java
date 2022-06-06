package com.springboot.demo.account.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeResponseTest {

    @Test
    public void test() {
        EmployeeResponse response = new EmployeeResponse();
        long timeStamp=System.currentTimeMillis();
        response.setStatus(200);
        response.setMessage("message");
        response.setTimeStamp(timeStamp);
        response.setName("name");
        response.setDepartment("dep");
        response.setMachine("machine");

        assertNotNull(response);
        assertEquals(200, response.getStatus());
        assertEquals("message", response.getMessage());
        assertEquals(timeStamp, response.getTimeStamp());
        assertEquals("name", response.getName());
        assertEquals("dep", response.getDepartment());
        assertEquals("machine", response.getMachine());

        Employee employee = new Employee();
        employee.setName("name");
        employee.setDepartment("dep");
        employee.setMachine("machine");
        EmployeeResponse response1 = new EmployeeResponse("message",employee);
        response1.setTimeStamp(timeStamp);

        assertNotNull(response1);
        assertTrue(new ReflectionEquals(response).matches(response1));
    }
}
