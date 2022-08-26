package com.springboot.demo.employee.v1.controller;

import com.springboot.demo.employee.v1.request.EmployeeCreationRequest;
import com.springboot.demo.employee.v1.request.EmployeeUpdationRequest;
import com.springboot.demo.employee.v1.response.EmployeeDeleteResponse;
import com.springboot.demo.employee.v1.response.ErrorResponse;
import com.springboot.demo.employee.service.EmployeeService;
import com.springboot.demo.employee.v1.response.EmployeeListResponse;
import com.springboot.demo.employee.v1.response.EmployeeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/v1")
@Tag(name = "Employee Controller", description = "Employee Service")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get all employees",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeeListResponse.class)))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(schema = @Schema(implementation = EmployeeListResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public EmployeeListResponse getAllEmployees() {
        EmployeeListResponse response = employeeService.getAllEmployees();
        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get employee by id",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public EmployeeResponse getEmployeeById(
            @Parameter(in = ParameterIn.DEFAULT, name = "id", description = "Employee Id", required = true, example = "123")
            @NotNull(message = "Employee Id cannot be null") @PathVariable("id") Integer id) {
        EmployeeResponse response = employeeService.getEmployeeById(id);
        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Add new employee",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public EmployeeResponse addEmployee(
            @Parameter(in = ParameterIn.DEFAULT, description = "Employee Creation Request", required = true)
            @RequestBody @Valid EmployeeCreationRequest request) {
        EmployeeResponse response = employeeService.addEmployee(request);
        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update existing employee",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeeResponse.class)))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(schema = @Schema(implementation = EmployeeResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public EmployeeResponse updateEmployee(
            @Parameter(in = ParameterIn.DEFAULT, description = "Employee Updation Request", required = true)
            @RequestBody @Valid EmployeeUpdationRequest request) {
        EmployeeResponse response = employeeService.updateEmployee(request);
        return response;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/employees/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Delete employee by id",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = EmployeeDeleteResponse.class)))})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok",
                    content = @Content(schema = @Schema(implementation = EmployeeDeleteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "406", description = "Not Acceptable",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "415", description = "Unsupported Media Type",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))})
    public EmployeeDeleteResponse deleteEmployeeById(
            @Parameter(in = ParameterIn.DEFAULT, name = "id", description = "Employee Id", required = true, example = "123")
            @NotNull(message = "Employee Id cannot be null") @PathVariable("id") Integer id) {
        EmployeeDeleteResponse response = employeeService.deleteEmployeeById(id);
        return response;
    }
}
