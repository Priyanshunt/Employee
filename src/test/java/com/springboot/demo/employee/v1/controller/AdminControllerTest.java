package com.springboot.demo.employee.v1.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AdminController adminController;

    @Test
    public void swaggerTest() {
        adminController = new AdminController();
        String response = "redirect:/swagger-ui.html";
        assertEquals(response, adminController.swagger());
    }

    @Test
    public void pingCheckTest() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
        String response = "I am Alive.";
        ResultActions result = mockMvc.perform(get("/v1/ping").accept(MediaType.TEXT_PLAIN));
        result.andExpectAll(status().isOk(), content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN),
                content().string(response));
    }
/**
    @Test
    public void h2ConsoleTest() {
        adminController = new AdminController();
        String response = "redirect:/home.jsp";
        assertEquals(response, adminController.h2Console());
    }
**/
}
