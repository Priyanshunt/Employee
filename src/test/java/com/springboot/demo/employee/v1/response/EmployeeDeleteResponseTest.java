package com.springboot.demo.employee.v1.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDeleteResponseTest {

    @Test
    public void test() {
        Integer id = 123;
        EmployeeDeleteResponse response = new EmployeeDeleteResponse();
        response.setId(id);

        assertNotNull(response);
        assertEquals(id, response.getId());

        EmployeeDeleteResponse response1 = new EmployeeDeleteResponse(200, "message", id);

        assertNotNull(response1);
        assertTrue(response.getId() == response1.getId());
        assertFalse(new ReflectionEquals(response).matches(response1));
    }
}
