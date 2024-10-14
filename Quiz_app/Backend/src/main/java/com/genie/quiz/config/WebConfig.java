package com.genie.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Allows all endpoints
                .allowedOrigins("http://127.0.0.1:5500") // Allows your frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS","PATCH")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
