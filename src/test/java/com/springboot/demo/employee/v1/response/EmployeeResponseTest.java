package com.springboot.demo.employee.v1.response;

import com.springboot.demo.employee.repository.model.Employee;
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
        EmployeeResponse response = new EmployeeResponse();
        response.setEmployee(employee);

        assertNotNull(response);
        assertTrue(new ReflectionEquals(response.getEmployee()).matches(employee));

        EmployeeResponse response1 = new EmployeeResponse(200, "message", employee);

        assertNotNull(response1);
        assertTrue(new ReflectionEquals(response.getEmployee()).matches(response1.getEmployee()));
        assertFalse(new ReflectionEquals(response).matches(response1));
    }
}
