package com.springboot.demo.employee.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Admin Controller", description = "Admin Service")
public class AdminController {
    
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    @Operation(summary = "Ping Check", hidden = true,
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }

    @GetMapping(value = "/v1/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "Ping Check",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<String> pingCheck() {
        return new ResponseEntity<>("I am Alive.", HttpStatus.OK);
    }

/**
    @GetMapping(value = "/h2-console", produces = MediaType.TEXT_HTML_VALUE)
    @Operation(summary = "Ping Check", hidden = true,
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<String> h2Console() {
    return new ResponseEntity<>("redirect:home.jsp", HttpStatus.OK);
    }
 **/

}
