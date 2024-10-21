package com.example.demo.security;

import org.springframework.context.annotation.Configuration;

@Configuration

public class SecurityConfig {

    private static final String[] SWAGGER_WHITELIST = {
            "/swagger-ui/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-resources"
    };


}
