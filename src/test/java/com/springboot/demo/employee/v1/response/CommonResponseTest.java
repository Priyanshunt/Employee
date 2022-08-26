package com.springboot.demo.employee.v1.response;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommonResponseTest {

    @Test
    public void test() {
        CommonResponse response = new CommonResponse();
        response.setStatus(200);
        response.setMessage("message");

        assertNotNull(response);
        assertEquals(Integer.valueOf(200), response.getStatus());
        assertEquals("message", response.getMessage());
        assertTrue(response.getTimeStamp() != null && response.getTimeStamp() > 0);

        CommonResponse response1 = new CommonResponse(200, "message");
        response1.setTimeStamp(response.getTimeStamp());

        assertNotNull(response1);
        assertTrue(new ReflectionEquals(response).matches(response1));
    }
}
