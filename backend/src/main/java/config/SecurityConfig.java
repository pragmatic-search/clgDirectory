
package com.college.directory.config;

import com.college.directory.service.AuthService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  private final AuthService authService;

  public SecurityConfig(AuthService authService) {
    this.authService = authService;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http)
      throws Exception {
    http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/login", "/register")
        .permitAll() // Public endpoints
        .anyRequest()
        .authenticated() // All other endpoints require authentication
        .and()
        .sessionManagement()
        .sessionCreationPolicy(
            SessionCreationPolicy.STATELESS); // No sessions, stateless JWT

    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public AuthenticationManager authenticationManager(HttpSecurity http)
      throws Exception {
    return http.getSharedObject(AuthenticationManagerBuilder.class)
        .userDetailsService(authService::login)
        .passwordEncoder(passwordEncoder())
        .and()
        .build();
  }
}
