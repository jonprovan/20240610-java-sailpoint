package com.skillstorm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http.httpBasic(Customizer.withDefaults())
				   .authorizeHttpRequests(reqs -> reqs.anyRequest().authenticated())
				   .csrf(csrf -> csrf.disable())
				   .build();
	}

}
