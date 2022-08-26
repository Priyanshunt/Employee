package com.springboot.demo.employee.v1.response;

import com.springboot.demo.employee.repository.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeListResponseTest {

    @Test
    public void test() {
        List<Employee> employeeList = new ArrayList<>();
        EmployeeListResponse response = new EmployeeListResponse();
        response.setEmployeeList(employeeList);

        assertNotNull(response);
        assertTrue(new ReflectionEquals(response.getEmployeeList()).matches(employeeList));

        EmployeeListResponse response1 = new EmployeeListResponse(200, "message", employeeList);

        assertNotNull(response1);
        assertTrue(new ReflectionEquals(response.getEmployeeList()).matches(response1.getEmployeeList()));
        assertFalse(new ReflectionEquals(response).matches(response1));
    }
}
