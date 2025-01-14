package com.example.HotelServer.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// Enables Spring Security in the application
@EnableWebSecurity
@RequiredArgsConstructor

public class WebSecurityConfiguration {

    // Declares this method as a Bean, allowing Spring to manage it
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Disables CSRF protection (useful for APIs, especially during development)
        http.csrf(AbstractHttpConfigurer::disable).authorizeHttpRequests(request->
                // Allows anyone to access endpoints under '/api/auth/**' without authentication
                request.requestMatchers("/api/auth/**").permitAll());

        return http.build();
    }

    //- Define a @Bean method to expose AuthenticationManager.
    @Bean
    // Use AuthenticationConfiguration to retrieve the AuthenticationManager instance.
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
