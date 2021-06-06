package com.martinez.apitest;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Application API").description(
                        "Springboot test API").contact(new Contact().name("Fernando Martínez Palacios").email("martinezpalaciosfernando@gmail.com")));
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}