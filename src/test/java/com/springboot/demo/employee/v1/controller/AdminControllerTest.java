package com.springboot.demo.employee.v1.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private AdminController adminController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void swaggerTest() throws Exception {
        String response = "redirect:/swagger-ui.html";
        ResultActions result = mockMvc.perform(get("/").accept(MediaType.TEXT_HTML));
        result.andExpectAll(status().isOk(), content().contentTypeCompatibleWith(MediaType.TEXT_HTML),
                content().string(response));
    }

    @Test
    public void pingCheckTest() throws Exception {
        String response = "I am Alive.";
        ResultActions result = mockMvc.perform(get("/v1/ping").accept(MediaType.TEXT_PLAIN));
        result.andExpectAll(status().isOk(), content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN),
                content().string(response));
    }

    @Test
    public void h2ConsoleTest() throws Exception {
        String response = "redirect:/home.jsp";
        ResultActions result = mockMvc.perform(get("/h2-console").accept(MediaType.TEXT_HTML));
        result.andExpectAll(status().isOk(), content().contentTypeCompatibleWith(MediaType.TEXT_HTML),
                content().string(response));
    }
}
