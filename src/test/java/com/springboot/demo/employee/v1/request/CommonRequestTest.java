package com.springboot.demo.employee.v1.request;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CommonRequestTest {

    @Test
    public void test() {
        CommonRequest request = new CommonRequest();
        request.setName("name");
        request.setDepartment("dep");
        request.setMachine("machine");

        assertNotNull(request);
        assertEquals("name", request.getName());
        assertEquals("dep", request.getDepartment());
        assertEquals("machine", request.getMachine());

        CommonRequest request1 = new CommonRequest("name", "dep", "machine");

        assertNotNull(request1);
        assertTrue(new ReflectionEquals(request).matches(request1));
    }
}
