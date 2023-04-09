package com.springboot.demo.employee.v1.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@EnableScheduling
@Tag(name = "Admin Controller", description = "Admin Service")
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping(value = "/")
    @Operation(summary = "Swagger", hidden = true,
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    public String swagger() {
        logger.info("{} redirecting to swagger", applicationName);
        return "redirect:/swagger-ui.html";
    }

    @Scheduled(fixedRate = 60000)
    @GetMapping(value = "/v1/ping", produces = MediaType.TEXT_PLAIN_VALUE)
    @Operation(summary = "Ping Check",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<String> pingCheck() {
        logger.info("{} application is alive", applicationName);
        return new ResponseEntity<>("I am Alive.", HttpStatus.OK);
    }

/**
    @GetMapping(value = "/h2-console")
    @Operation(summary = "H2 Console",
            responses = {@ApiResponse(content = @Content(schema = @Schema(implementation = String.class)))})
    @ApiResponse(responseCode = "200", description = "Ok")
    public String h2Console() {
        logger.info("Redirecting to h2 console of {}", applicationName);
        return "redirect:home.jsp";
    }
 **/

}
