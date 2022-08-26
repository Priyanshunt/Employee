package com.springboot.demo.employee.v1.request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeCreationRequestTest {

    @Test
    public void test() {
        EmployeeCreationRequest request = new EmployeeCreationRequest();
        assertNotNull(request);

        EmployeeCreationRequest request1 = new EmployeeCreationRequest("name", "dep", "machine");

        assertNotNull(request1);
        assertFalse(new ReflectionEquals(request).matches(request1));
    }
}
