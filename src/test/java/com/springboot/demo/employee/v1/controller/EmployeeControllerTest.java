package com.springboot.demo.employee.v1.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.employee.service.EmployeeService;
import com.springboot.demo.employee.v1.request.EmployeeCreationRequest;
import com.springboot.demo.employee.v1.request.EmployeeUpdationRequest;
import com.springboot.demo.employee.v1.response.EmployeeDeleteResponse;
import com.springboot.demo.employee.v1.response.EmployeeListResponse;
import com.springboot.demo.employee.v1.response.EmployeeResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Spy
    private ObjectMapper objectMapper;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    public void getAllEmployeesTest() throws Exception {
        EmployeeListResponse response = new EmployeeListResponse(200, "message", null);
        when(employeeService.getAllEmployees()).thenReturn(response);
        ResultActions result = mockMvc.perform(get("/v1/employees").accept(MediaType.APPLICATION_JSON));
        verify(employeeService, times(1)).getAllEmployees();
        result.andExpectAll(status().isOk(), content().contentType(MediaType.APPLICATION_JSON),
                content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    public void getEmployeeByIdTest() throws Exception {
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        Integer id = 123;
        when(employeeService.getEmployeeById(anyInt())).thenReturn(response);
        ResultActions result = mockMvc.perform(get("/v1/employees/123").accept(MediaType.APPLICATION_JSON));
        verify(employeeService, times(1)).getEmployeeById(id);
        result.andExpectAll(status().isOk(), content().contentType(MediaType.APPLICATION_JSON),
                content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    public void addEmployeeTest() throws Exception {
        EmployeeCreationRequest request = new EmployeeCreationRequest();
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        when(employeeService.addEmployee(any(EmployeeCreationRequest.class))).thenReturn(response);
        ResultActions result = mockMvc.perform(post("/v1/employees").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)));
        verify(employeeService, times(1)).addEmployee(any(EmployeeCreationRequest.class));
        result.andExpectAll(status().isOk(), content().contentType(MediaType.APPLICATION_JSON),
                content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    public void updateEmployeeTest() throws Exception {
        EmployeeUpdationRequest request = new EmployeeUpdationRequest();
        EmployeeResponse response = new EmployeeResponse(200, "message", null);
        when(employeeService.updateEmployee(any(EmployeeUpdationRequest.class))).thenReturn(response);
        ResultActions result = mockMvc.perform(put("/v1/employees").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request)));
        verify(employeeService, times(1)).updateEmployee(any(EmployeeUpdationRequest.class));
        result.andExpectAll(status().isOk(), content().contentType(MediaType.APPLICATION_JSON),
                content().json(objectMapper.writeValueAsString(response)));
    }

    @Test
    public void deleteEmployeeByIdTest() throws Exception {
        EmployeeDeleteResponse response = new EmployeeDeleteResponse(200, "message", null);
        Integer id = 123;
        when(employeeService.deleteEmployeeById(anyInt())).thenReturn(response);
        ResultActions result = mockMvc.perform(delete("/v1/employees/123").accept(MediaType.APPLICATION_JSON));
        verify(employeeService, times(1)).deleteEmployeeById(id);
        result.andExpectAll(status().isOk(), content().contentType(MediaType.APPLICATION_JSON),
                content().json(objectMapper.writeValueAsString(response)));;
    }
}
