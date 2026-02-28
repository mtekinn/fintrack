package com.example.fintrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class FintrackApplication {
    public static void main(String[] args) {
        SpringApplication.run(FintrackApplication.class, args);
    }
}
