package com.springboot.demo.employee.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    @Value("${api.version}")
    private String apiVersion;

    @Bean
    public OpenAPI springShopOpenApi() throws UnknownHostException {
        OpenAPI openAPI = new OpenAPI();
        openAPI.info(new Info().title("Employee Documentation")
                .version(apiVersion));
        return openAPI;
    }
}
