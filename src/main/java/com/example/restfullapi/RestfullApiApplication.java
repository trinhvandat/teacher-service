package com.example.restfullapi;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestfullApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfullApiApplication.class, args);
    }

}
