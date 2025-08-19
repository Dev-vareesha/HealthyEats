package com.healthyeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.healthyeats.model") // Make sure Spring knows where to look for entities
public class HealthyEatsApplication {
    public static void main(String[] args) {
        SpringApplication.run(HealthyEatsApplication.class, args);
    }
}
