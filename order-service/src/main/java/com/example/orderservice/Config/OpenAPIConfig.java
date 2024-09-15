package com.example.orderservice.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI OrderService(){
        return new OpenAPI().info(new Info()
                .title("Order Service API")
                .description("This is the Order Service API")
                .version("v0.0.0.1")
                .license(new License().name("Apache 2.0")))
                .externalDocs(new ExternalDocumentation()
                        .description("Click here to refer to api docs")
                        .url("http://localhost:8080"));

    }
}
