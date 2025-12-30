/*package com.neurofleetx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain permitAllFilterChain(HttpSecurity http) throws Exception {
        // Since you have a JWTAuthenticationFilter, we need to disable CSRF 
        // and allow all requests for testing purposes, but we also ensure 
        // no form login is required by default.
        http
            // 1. Disable CSRF protection (essential for stateless APIs)
            .csrf(csrf -> csrf.disable())
            
            // 2. Disable default form login and basic auth
            .formLogin(form -> form.disable()) 
            .httpBasic(httpBasic -> httpBasic.disable())
            
            // 3. Configure authorization rules
            .authorizeHttpRequests(auth -> auth
                // Allow ALL requests to ALL endpoints (Fixes 403 Forbidden)
                .anyRequest().permitAll()
            );
            
        // You might need to adjust the line below depending on how 
        // your JWTAuthenticationFilter is set up, but this is the core fix.
        
        return http.build();
    }
}*/
package com.neurofleetx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // THIS FIXES THE "Field authenticationManager" ERROR
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(auth -> auth
                // Use the simplified path we set in your controller
                .requestMatchers("/api/buses/**", "/buses/**").permitAll() 
                .anyRequest().permitAll() // Opens everything else for testing
            );
        
        return http.build();
    }
}