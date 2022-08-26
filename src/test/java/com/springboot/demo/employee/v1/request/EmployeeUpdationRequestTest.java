package com.springboot.demo.employee.v1.request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeUpdationRequestTest {

    @Test
    public void test() {
        Integer id = 123;
        EmployeeUpdationRequest request = new EmployeeUpdationRequest();
        request.setId(id);

        assertNotNull(request);
        assertEquals(id, request.getId());

        EmployeeUpdationRequest request1 = new EmployeeUpdationRequest(id, "name", "dep", "machine");

        assertNotNull(request1);
        assertTrue(request.getId() == request1.getId());
        assertFalse(new ReflectionEquals(request).matches(request1));
    }
}
