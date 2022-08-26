package com.springboot.demo.employee.v1.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ErrorResponseTest {

    @Test
    public void test() {
        String details = "Details";
        ErrorResponse response = new ErrorResponse();
        response.setDetails(details);

        assertNotNull(response);
        assertEquals(details, response.getDetails());

        ErrorResponse response1 = new ErrorResponse(200, "message", details);

        assertNotNull(response1);
        assertTrue(response.getDetails().equals(response1.getDetails()));
        assertFalse(new ReflectionEquals(response).matches(response1));
    }
}
